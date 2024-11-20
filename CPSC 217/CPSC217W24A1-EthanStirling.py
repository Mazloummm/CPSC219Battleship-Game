# SimpleGraphics Boat and Sun Program
# Author: Your Name
# Student Number: Your Student Number
# Purpose: Draw a landscape with a movable boat and sun

# Import the SimpleGraphics library
from SimpleGraphics import *

# Set the window size
width, height = 800, 600
resize(width, height)

# Function to draw the landscape
def draw_landscape():
    # Draw ocean
    setFill("blue")
    rect(0, height // 2, width, height // 2)

    # Draw sky
    setFill("lightblue")
    rect(0, 0, width, height // 2)

    # Draw island
    setFill("green")
    draw_island(400, 500, 100)

def draw_island(x, y, size):
    setColor("greenyellow")
    setOutline("brown")  # Set color for the island
    blob(x - size, y - size/2, x + size, y - size/2, x + size/2, y + size, x - size/2, y + size)  # Draw the island using blob()

# Function to draw the boat
def draw_boat(x, y):
    setColor("brown") # Set color for the boat hull
    setOutline("black")  
    rect(x - 40, y - 10, 190, 80)  # Draw the boat hull
    
    setColor("brown") # Set color for mast
    setOutline("brown")
    rect(x + 10, y - 50, 10, 100)

    setColor("white")  # Set color for the sail
    setOutline("black")
    polygon(x, y - 25, x, y - 75, x + 50, y - 25)  # Draw the sail

    # Draw portholes
    setFill("black")
    setOutline("black")
    ellipse(x - 30, y, 20, 20)
    ellipse(x + 20, y, 20, 20)
    ellipse(x + 70, y, 20, 20)
    ellipse(x + 120, y, 20, 20)

# Function to draw the sun
def draw_sun(x, y):
    setFill("yellow")
    setOutline("black")
    ellipse(x - 25, y - 25, 150, 150)

# Main program
def main():
    # Draw initial landscape
    draw_landscape()

    # Prompt user for boat position
    boat_x = int(input("Enter the x-position of the boat: "))
    boat_y = int(input("Enter the y-position of the boat: "))

    # Draw the boat
    draw_boat(boat_x, boat_y)

    # Prompt user for sun position
    sun_x = int(input("Enter the x-position of the sun: "))
    sun_y = int(input("Enter the y-position of the sun: "))

    # Draw the sun
    draw_sun(sun_x, sun_y)

    # Wait for the user to close the window
    while not closed():
        update()

# Run the program
main()
