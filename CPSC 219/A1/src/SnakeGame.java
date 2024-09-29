// Amr Ibrahim UCID #30219524
// Ethan Stirling UCID #30229189
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    // Constants declared
    public static final int GRID_SIZE_X = 20;    // Width of row
    public static final int GRID_SIZE_Y = 10;    // Height of column
    public static final int MAX_SNAKE_LENGTH = 100;
    public static final char SNAKE_CHAR = 'S';   // Snake on the grid
    public static final char FOOD_CHAR = '@';    // Food on the grid
    public static final char EMPTY_CHAR = '.';   // Empty space of the grid
    public static final char WALL_CHAR = '#';    // Wall of the grid
    public static final char PORTAL_CHAR = 'O';  // Portal on the grid
    public static final char OBSTACLE_CHAR = '%';// Obstacle on the grid

    // Variables declared
    public static char[][] grid;                // The game space grid
    public static int snakeLength;              // Current snake length tracker
    public static int[][] snake;                // Body of snake
    public static int foodX, foodY;             // Position of food
    public static char direction = 'd';         // Current direction of the snake
    public static boolean isGameOver = false;  // Game over flag

    // Initialize the grid
    public static void initializeGame() {
        grid = new char[GRID_SIZE_Y][GRID_SIZE_X];
        
        // Loop for creating walls, borders, and empty space.
        for (int y = 0; y < GRID_SIZE_Y; y++) {
            for (int x = 0; x < GRID_SIZE_X; x++) {
                if (y == 0 || y == GRID_SIZE_Y - 1 || x == 0 || x == GRID_SIZE_X - 1) {
                    grid[y][x] = WALL_CHAR;  // Create walls
                } else {
                    grid[y][x] = EMPTY_CHAR; // Create empty space
                }
            }
        }

        // Loop for creating portals on the walls
        for (int y = 1; y < GRID_SIZE_Y; y++) {
            if (y % 2 == 0) {
                grid[y][0] = PORTAL_CHAR; // Create portals on the left wall
                grid[y][GRID_SIZE_X - 1] = PORTAL_CHAR; // Create portals on the right wall
            }
        }

        // Loop for creating portals on the top and bottom walls
        for (int x = 0; x < GRID_SIZE_X - 1; x++) {
            if (x % 2 != 0) {
                grid[0][x] = PORTAL_CHAR; // Create portals on the top wall
                grid[GRID_SIZE_Y - 1][x] = PORTAL_CHAR; // Create portals on the bottom wall
            }
        }

        generateFood(); // Generation of Food

        generateObstacles(); // Generation of Obstacles

        generateSnake(); // Generation of Snake

    }

    // Generate the snake at the center of the grid
    public static void generateSnake() {
        Random random = new Random();
        snakeLength = 3; // Initial snake length
        snake = new int[MAX_SNAKE_LENGTH][2]; // Space for snake
        int startX, startY;

        // Generate a valid random coordinate start
        do {
            startX = random.nextInt(GRID_SIZE_X - 2) + 1; // Random value between 1 and GRID_SIZE_X-2
            startY = random.nextInt(GRID_SIZE_Y - 2) + 1; // Random value between 1 and GRID_SIZE_Y-2
        } while (grid[startY][startX] != EMPTY_CHAR); // Loop runs until an empty space is found

        // Place the snake on the grid
        snake[0][0] = startY; // Y-coordinate of the head
        snake[0][1] = startX; // X-coordinate of the head
        grid[startY][startX] = SNAKE_CHAR; // Place the head on the grid
    }

    // Generate food at a random location
    public static void generateFood() {
        Random rand = new Random();
        do {
            foodX = rand.nextInt(GRID_SIZE_X - 1) + 1; // X-coordinate (1-19)
            foodY = rand.nextInt(GRID_SIZE_Y - 1) + 1; // Y-coordinate (1-9)
        } while (grid[foodY][foodX] != EMPTY_CHAR); // Ensure food is not placed on the snake

        grid[foodY][foodX] = FOOD_CHAR; // Place food on the grid
    }

    // Generate obstacles at random locations
    public static void generateObstacles() {
        Random rand = new Random();
        int numObstacles = rand.nextInt(3) + 1; // Random number of obstacles (1-3)
        for (int i = 0; i < numObstacles; i++) {
            int x, y;
            do {
                x = rand.nextInt(GRID_SIZE_X - 2); // X-coordinate (2-18)
                y = rand.nextInt(GRID_SIZE_Y - 2); // Y-coordinate (2-8)
                if (x <= 1){ // If the obstacle is placed on the top wall
                    x += 2;
                }
                if (y <= 1){ // If the obstacle is placed on the left wall
                    y += 2;
                } // Ensure obstacle is not placed beside a portal
            } while (grid[y][x] != EMPTY_CHAR); // Ensure obstacle is not placed on the snake or food
            grid[y][x] = OBSTACLE_CHAR; // Place obstacle on the grid
        }
    }

    // Update the snake's position and check for collisions
    public static void updateSnakePosition(char direction) {
        // Calculate new head position
        int newHeadX = snake[0][1];
        int newHeadY = snake[0][0];
        
        // Update the head position based on the direction
        switch (direction) {
            case 'w': newHeadY--; // Move up
            break;
            case 's': newHeadY++; // Move down
            break; 
            case 'a': newHeadX--; // Move left
            break; 
            case 'd': newHeadX++; // Move right
            break; 
        }

        // Check for collision with walls or self
        if (!isValidMove(newHeadX, newHeadY)) {
            isGameOver = true;
            return;
        }

        // Check if the snake has eaten the food
        if (newHeadX == foodX && newHeadY == foodY) {
            // Grow the snake
            snakeLength++;
            generateFood(); // Place new food
        } else {
            // Clear the tail from the grid
            int tailX = snake[snakeLength - 1][1];
            int tailY = snake[snakeLength - 1][0];
            // Tail is cleared if it is not at the initial position
            if (tailX != 0 && tailY != 0) {
                grid[tailY][tailX] = EMPTY_CHAR;
            }
        }

        // Move the snake's body
        for (int i = snakeLength - 1; i > 0; i--) {
            snake[i][0] = snake[i - 1][0];
            snake[i][1] = snake[i - 1][1];
        }

        // Check if the snake has reached the portal on the walls and move to the other side
        if (grid[newHeadY][newHeadX] == PORTAL_CHAR) {
            // Check if the portal is on the top or bottom wall
            if (newHeadY == GRID_SIZE_Y - 1) {
                newHeadY = GRID_SIZE_Y - newHeadY; // Move to the top wall
            } else if (newHeadY == 0) {
                newHeadY = GRID_SIZE_Y - 2; // Move to the bottom wall
        
            // Check if the portal is on the left or right wall
            } else if (newHeadX == GRID_SIZE_X - 1) {
                newHeadX = GRID_SIZE_X - newHeadX; // Move to the left wall
            } else if (newHeadX == 0) {
                newHeadX = GRID_SIZE_X - 2; // Move to the right wall
            }
        }

        // Update the snake's head position
        snake[0][1] = newHeadX;
        snake[0][0] = newHeadY;

        // Place the new head on the grid
        grid[newHeadY][newHeadX] = SNAKE_CHAR;
    }

    // Check if the move is valid (i.e., within boundaries and not hitting itself)
    public static boolean isValidMove(int x, int y) {
        // Check if the new position is outside the grid or on the wall
        if (grid[y][x] == WALL_CHAR || grid[y][x] == OBSTACLE_CHAR) {
            return false;
        }

        // Check if the new position collides with itself
        for (int i = 0; i < snakeLength; i++) {
            if (snake[i][0] == y && snake[i][1] == x) {
                return false;
            }
        }
        return true;
    }

    // Display the grid
    public static void displayGrid() {
        for (int y = 0; y < GRID_SIZE_Y; y++) {
            for (int x = 0; x < GRID_SIZE_X; x++) {
                System.out.print(grid[y][x]); // Print each cell without newline
            }
            System.out.println(); // Newline after each row
        }
    }

    // Main game loop
    public static void main(String[] args) {
        // Initialize the game
        initializeGame();
        // Display the initial grid
        displayGrid();
        
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (!isGameOver) {
            char direction = ' ';
            boolean quitKeyPressed = false;
            boolean validInput = false;
            
            // Get user input for the next move
            while (!validInput) {
                System.out.println("Enter a direction ('w', 'a', 's', 'd') or quit game ('q'): ");
                direction = scanner.next().charAt(0);
                // Check if the input is valid
                if (direction == 'w' || direction == 's' || direction == 'a' || direction == 'd') {
                    validInput = true;
                } else if (direction == 'q') {
                    quitKeyPressed = true;
                    break;
                // If the input is invalid, prompt the user to enter a valid input
                } else {
                    System.out.println("Invalid input. Please enter 'w', 's', 'a', or 'd'.");
                }
            }

            // Move the snake in the given direction
            updateSnakePosition(direction);

            // Display the updated grid if the game is not over
            if (!isGameOver && !quitKeyPressed) {
                displayGrid();
            } else {
                // If the game is over, prompt the user to play again
                System.out.println("Game Over! Would you like to play again? (y/n)");
                char playAgain = scanner.next().charAt(0);
                // If the user wants to play again, reset the game
                if (playAgain == 'y') {
                    isGameOver = false;
                    initializeGame();
                    displayGrid();
                } else {
                    break;
                }
            }
        
        } // End of game loop

        scanner.close();
    }
}