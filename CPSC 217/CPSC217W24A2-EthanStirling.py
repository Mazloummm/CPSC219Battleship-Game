# Ethan Stirling #30229189
# Purpose: This program is a pictionary game where the user guesses the shape being drawn

from SimpleGraphics import *

# Constants
WINDOW_WIDTH = 800
WINDOW_HEIGHT = 800
ALLOWED_COLORS = ["black", "white", "blue", "green"]

# Get a valid color
def get_color(prompt):
    """Prompts the user for a color, ensuring it's one of the allowed colors, and returns a valid color."""
    while True:
        color = input(prompt).lower()
        if color in ALLOWED_COLORS:
            return color
        else:
            print(f"{color} is not a valid option. ")

# Get a valid coordinate
def get_coordinate(prompt):
    """Prompts the user for a coordinate, ensuring it's an integer between 0 and 800, and returns a valid coordinate."""
    while True:
        try:
            coord = int(input(prompt))
            if 0 <= coord <= 800:
                return coord
            else:
                print("Coordinate must be between 0 and 800.")
        except ValueError:
            print("Invalid input. Please enter an integer.")

# Main function
def main():
    # Set up graphics window
    resize(WINDOW_WIDTH, WINDOW_HEIGHT)

    # Get background and foreground colors
    background_color = get_color("What color do you want to use for the background? (black, white, blue, green) ")
    foreground_color = get_color("What color do you want to use for the foreground? (black, white, blue, green) ")
    
    # Ensure the colors are different
    while foreground_color == background_color:
        print("The foreground and background colors cannot be the same. Please choose different colors.")
        foreground_color = get_color("Which color do you want to use for the foreground? (black, white, blue, green) ")

    # Set up graphics window with user's colors
    setFill(background_color)
    rect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT)
    setOutline(foreground_color)
    setColor(foreground_color) 
    update()
    
    # Get secret word from drawer
    secret_word = input("What are you going to draw? (Hint: keep it simple) ")

    # Get starting coordinates
    start_x = get_coordinate("Enter the initial x-coordinate: ")
    start_y = get_coordinate("Enter the initial y-coordinate: ")
    current_x = start_x
    current_y = start_y
    line(start_x, start_y, start_x, start_y) # Initial dot
    update()
    count = 1

    # Print 10 blank lines to hide the secret word from the guesser
    for i in range(10):
        print()

    # Game loop
    game_over = False
    while not game_over:
        action = input("Do you want to either guess the drawing (1) or get the next point (2)? ")
        
        # Guess the drawing, if correct, game over
        if action.lower() == '1':
            guess = input("What do you think the drawing is? ")
            if guess.lower() == secret_word.lower():
                print(f"Gnarly! You guessed the picture after {count} points!")
                game_over = True
            else:
                print(f"Nope, it's not a {guess}. Keep trying!")
        
        # Get the next point to draw the picture
        elif action.lower() == '2':
            new_x = get_coordinate("Enter the x-coordinate of the next point: ")
            new_y = get_coordinate("Enter the y-coordinate of the next point: ")
            line(current_x, current_y, new_x, new_y) # Draw from the previous point to the new point
            update()
            current_x = new_x
            current_y = new_y
            count += 1

            # Drawing complete when the user returns to the starting point
            if new_x == start_x and new_y == start_y:
                game_over = True
                print(f"Game Over! The drawing was {secret_word}")

        # Invalid input
        else:   
            print("Invalid input. Please enter 1 or 2.")
    
    # Game over

# Run the program
main()