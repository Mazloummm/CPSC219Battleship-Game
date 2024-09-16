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
        Random random = new Random();
        
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

        generateFood(); // Generation of Food

        // Initialize the snake
        snakeLength = 3;
        snake = new int[MAX_SNAKE_LENGTH][2]; // Space for snake
        int startX, startY;

        // Generate a valid random coordinate start
        do {
            startX = random.nextInt(GRID_SIZE_X - 2) + 1; // Random value between 1 and GRID_SIZE_X-2
            startY = random.nextInt(GRID_SIZE_Y - 2) + 1; // Random value between 1 and GRID_SIZE_Y-2
        } while (grid[startY][startX] != EMPTY_CHAR); // Loop runs until an empty space is found

        // Place the snake on the grid
        for (int i = 0; i < snakeLength; i++) {
            snake[i][0] = startY;          // Y-coordinate of the snake segment
            snake[i][1] = startX - i;      // X-coordinate of the snake segment
            grid[snake[i][0]][snake[i][1]] = SNAKE_CHAR; // Place snake on the grid
        }
    }

    // Generate food at a random location
    public static void generateFood() {
        Random rand = new Random();
        do {
            foodX = rand.nextInt(GRID_SIZE_X - 2) + 1; // X-coordinate (1-18)
            foodY = rand.nextInt(GRID_SIZE_Y - 2) + 1; // Y-coordinate (1-8)
        } while (grid[foodY][foodX] != EMPTY_CHAR); // Ensure food is not placed on the snake

        grid[foodY][foodX] = FOOD_CHAR; // Place food on the grid
    }

    // Update the snake's position and check for collisions
    public static void moveSnake(char direction) {
        // Calculate new head position
        int newHeadX = snake[0][1];
        int newHeadY = snake[0][0];
        
        switch (direction) {
            case 'w': newHeadY--; break; // Move up
            case 's': newHeadY++; break; // Move down
            case 'a': newHeadX--; break; // Move left
            case 'd': newHeadX++; break; // Move right
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
            grid[tailY][tailX] = EMPTY_CHAR;
        }

        // Move the snake's body
        for (int i = snakeLength - 1; i > 0; i--) {
            snake[i][0] = snake[i - 1][0];
            snake[i][1] = snake[i - 1][1];
        }

        // Update the snake's head position
        snake[0][0] = newHeadY;
        snake[0][1] = newHeadX;

        // Place the new head on the grid
        grid[newHeadY][newHeadX] = SNAKE_CHAR;
    }

    // Check if the move is valid (i.e., within boundaries and not hitting itself)
    public static boolean isValidMove(int x, int y) {
        // Check if the new position is outside the grid or on the wall
        if (grid[y][x] == WALL_CHAR) {
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
        initializeGame();
        displayGrid();
        
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            char direction = ' ';
            boolean validInput = false;
            
            while (!validInput) {
                System.out.println("Enter a direction ('w', 'a', 's', 'd'): ");
                direction = scanner.next().charAt(0);
                if (direction == 'w' || direction == 's' || direction == 'a' || direction == 'd') {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter 'w', 's', 'a', or 'd'.");
                }
            }
            
            moveSnake(direction);
            displayGrid();
        } // End of game loop

        scanner.close();
    }
}
