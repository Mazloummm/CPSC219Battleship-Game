// Objective: Implent a snake game in java
import java.util.Random;

public class SnakeGame {
    // Constants declared
public static final int GRID_SIZE_X= 20;    // Width of row
public static final int Grid_SIZE_Y = 10;  // Height of column
public static final int MAX_SNAKE_LENGTH = 100;
public static final char SNAKE_CHAR = 'S'; // Snake on the grid
public static final char FOOD_CHAR = '@'; // FOod on the grid
public static final char EMPTY_CHAR = '.'; // Empty space of the grid
public static final char WALL_CHAR = '#'; // Wall of the grid


// Variables declared
public static char[][] grid; // The game space grid
public static int snakeLength; // Current snake length tracker
public static int snake[][]; // Body of snake

// Initialize the grid

public static void initializeGame() {
    grid = new char[Grid_SIZE_Y][GRID_SIZE_X];
    Random random = new Random();
    // Loop for creating walls, borders, and empty space.
    for (int y = 0; y < Grid_SIZE_Y; y++) {
        for (int x = 0; x < GRID_SIZE_X; x++) {
            if (y == 0 || y == Grid_SIZE_Y-1 || x == 0 || x == GRID_SIZE_X-1) {
                grid[y][x] = WALL_CHAR;  // create walls             
            } else {
                grid[y][x] = EMPTY_CHAR; // create empty space
            }
        }
    }
 // Initialize the snake
int snakeLength = 3;
snake = new int[MAX_SNAKE_LENGTH][2]; // Space for snake
int startX = 0, startY = 0;

// Generate a valid random coordinate start
do {
    // Randomized position of snake within valid grid boundaries (not walls)
    startX = random.nextInt(GRID_SIZE_X - 2) + 1; // Random value between 1 and Grid_Size_X-2
    startY = random.nextInt(Grid_SIZE_Y - 2) + 1; // Random value between 1 and Grid_Size_Y-2
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
        int foodPosX = rand.nextInt(19) + 1; // X-coordinate (1-19)
        int foodPosY = rand.nextInt(9) + 1; // Y-coordinate (1-9)

        if (grid[foodPosX][foodPosY] == EMPTY_CHAR) { // Check if the position is empty
            grid[foodPosX][foodPosY] = FOOD_CHAR; // Add food to grid
        } else {
            generateFood(); // New coordinates if position in snake
        }
    }

public static void displayGrid() {
    for (int y = 0; y < Grid_SIZE_Y; y++) {
      for (int x = 0; x < GRID_SIZE_X; x++) {
        System.out.print(grid[y][x]); // Print each cell without newline
      }
      System.out.println(); // Newline after each row
    }
  }

  public static void main(String[] args) {
    initializeGame();
    displayGrid();

}






}