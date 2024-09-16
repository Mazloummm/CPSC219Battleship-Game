import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    // Constants declared
    public static final int GRID_SIZE_X = 20;    // Width of row
    public static final int GRID_SIZE_Y = 10;  // Height of column
    public static final int MAX_SNAKE_LENGTH = 100;
    public static final char SNAKE_CHAR = 'S'; // Snake on the grid
    public static final char FOOD_CHAR = '@'; // FOod on the grid
    public static final char EMPTY_CHAR = '.'; // Empty space of the grid
    public static final char WALL_CHAR = '#'; // Wall of the grid


    // Variables declared
    public static char[][] grid; // The game space grid
    public static int snakeLength; // Current snake length tracker
    public static int snake[][]; // Body of snake
    public static boolean isGameOver = false; // Game over flag

    // Initialize the grid

    public static void initializeGame() {
        grid = new char[GRID_SIZE_Y][GRID_SIZE_X];
        Random random = new Random();
        
        // Loop for creating walls, borders, and empty space.
        for (int y = 0; y < GRID_SIZE_Y; y++) {
            for (int x = 0; x < GRID_SIZE_X; x++) {
                if (y == 0 || y == GRID_SIZE_Y-1 || x == 0 || x == GRID_SIZE_X-1) {
                    grid[y][x] = WALL_CHAR;  // create walls             
                } else {
                    grid[y][x] = EMPTY_CHAR; // create empty space
                }
            }
        }

        generateFood(); // Generation of Food

        // Initialize the snake
        int snakeLength = 3;
        snake = new int[MAX_SNAKE_LENGTH][2]; // Space for snake
        int startX = 0, startY = 0;

        // Generate a valid random coordinate start
        do {
            // Randomized position of snake within valid grid boundaries (not walls)
            startX = random.nextInt(GRID_SIZE_X - 2) + 1; // Random value between 1 and GRID_SIZE_X-2
            startY = random.nextInt(GRID_SIZE_Y - 2) + 1; // Random value between 1 and GRID_SIZE_Y-2
        } while (grid[startY][startX] != EMPTY_CHAR); // Loop runs until an empty space is found


        // Place the snake on the grid
        for (int i = 0; i < snakeLength; i++) {
            snake[i][0] = startY + i;  // Y-coordinate of the snake segment
            snake[i][1] = startX;      // X-coordinate of the snake segment
            if (i==0) {
                grid[snake[i][0]][snake[i][1]] = SNAKE_CHAR; // Add the snake head

            }
        }
    }

    public static void generateFood() {
            Random rand = new Random();
            int foodPosX = rand.nextInt(GRID_SIZE_X - 1) + 1; // X-coordinate (1-19)
            int foodPosY = rand.nextInt(GRID_SIZE_Y - 1) + 1; // Y-coordinate (1-9)

            if (grid[foodPosY][foodPosX] == EMPTY_CHAR) { // Check if the position is empty
                grid[foodPosY][foodPosX] = FOOD_CHAR; // Add food to grid
            } else {
                generateFood(); // New coordinates if position in snake
            }
    }

    public static void updateSnakePosition(int newX, int newY) {
        // To be implemented: Trim the tail only if it's not the initial stages of the game

        // To be implemented: Move the segments of the body 2 <- 1, 1 <- 0, new 0

        // To be implemented: update the snake's head position

        /** Check if the given coords are a valid move for the snake.
         * A move is valid if it is within the grid boundaries and does not
         * result in the snake colliding with itself or the walls.
         * 
         * @param x The X coordinate to check.
         * @param y The Y coordinate to check.
         * @return True if the move is valid, false otherwise.
         */
    
    }

    public static boolean isValidMove(int x, int y) {
        // return false if the move hits wall or snake
        return true; // Valid move
    }

    public static void moveSnake(char direction) {
        // Check isValidMove before updating the snake's position
        switch (direction) {
            case 'w': // Move up
                break;
            case 's': // Move down
                break;
            case 'a': // Move left
                break;
            case 'd': // Move right
                break;
                }
    }

    public static void displayGrid() {
        for (int y = 0; y < GRID_SIZE_Y; y++) {
            for (int x = 0; x < GRID_SIZE_X; x++) {
                System.out.print(grid[y][x]); // Print each cell without newline
            }
        System.out.println(); // Newline after each row
        }
    }

    public static void main(String[] args) {

        initializeGame();
        displayGrid();
        
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            char direction = ' ';
            boolean validInput = false;
            
            while(validInput == false) {
                System.out.println("Enter a direction ('w', 'a', 's', 'd'): ");
                direction = scanner.next().charAt(0);
                if (direction == 'w' || direction == 's' || direction == 'a' || direction == 'd') {
                    validInput = true;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'w', 's', 'a', or 'd'.");
                }
            }
            
            // moveSnake(direction);
            displayGrid();

        } // End of game loop

        scanner.close();
        
    }

}
