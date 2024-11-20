 // Purpose: Implement a simple snake game in Java.
public class SnakeGame {

  /*
   * Holds the current state of the game grid. Coordinates are represented as (X,
   * Y).
   * Coordinate 0,0 is the top-left corner of the grid and is always a wall.
   */
  public static char[][] grid;

  /*
   * int[][] snake represents the snake's body with each row as a segment.
   * snake[i][0] is the X-coordinate (row) of segment i
   * snake[i][1] is the Y-coordinate (column) of segment i
   *
   * Example: snake = new int[3][2]; // A snake with 3 segments
   *
   * snake[0][0] = 3; // X-coordinate of head (first segment)
   * snake[0][1] = 2; // Y-coordinate of head (first segment)
   *
   * snake[1][0] = 2; // X-coordinate of second segment
   * snake[1][1] = 2; // Y-coordinate of second segment
   *
   * snake[2][0] = 1; // X-coordinate of third segment (tail)
   * snake[2][1] = 2; // Y-coordinate of third segment (tail)
   *
   * Visually, the snake on the grid looks like this (X, Y):
   * (3, 2) ← Head
   * (2, 2)
   * (1, 2) ← Tail
   *
   * The snake array holds these coordinates to represent its position on the
   * grid.
   */
  public static int[][] snake;

  // The current length of the snake
  public static int snakeLength;

  // The game over flag
  public static boolean isGameOver = false;

  // Implement the following constants
  GRID_SIZE_X // the number of columns
  GRID_SIZE_Y // the number of rows
  SNAKE_CHAR;
  FOOD_CHAR;
  EMPTY_CHAR;
  WALL_CHAR;
  MAX_SNAKE_LENGTH;

  /**
   * Initializes the grid, creates the wall, snake and food
   */
  public static void initializeGame() {
    grid = new char[GRID_SIZE_Y][GRID_SIZE_X];

    // TODO: Create the walls, snake and food

  }

  /**
   * Adds the snake to the game grid.
   */
  public static void generateSnake() {
  }

  /**
   * Updates the snake's position on the grid and adjusts the snake's body
   * coordinates. Note: coordinates are given in the order of (X, Y).
   *
   * @param newX The new X coordinate of the snake's head.
   * @param newY The new Y coordinate of the snake's head.
   */
  public static void updateSnakePosition(int newX, int newY) {

    // TODO: Trim the tail only if it's not the initial stages of the game
    //  i.e., the first three moves the length of the snake will be 1, 2, and 3
    //  respectively.

    // TODO: Move the segments of the body 2 <- 1, 1 <- 0, new 0

    // TODO: update the snake's head position
  }

  /**
   * Checks if the given coordinates are a valid move for the snake.
   * A move is valid if it is within the grid boundaries and does not
   * result in the snake colliding with itself or the walls.
   *
   * @param x The X coordinate to check.
   * @param y The Y coordinate to check.
   * @return true if the move is valid, false otherwise.
   */
  public static boolean isValidMove(int x, int y) {
  }

  /**
   * Displays the current state of the game grid to the console.
   * i.e., this is where you print the display to the console
   */
  public static void displayGrid() {
  }

  /**
   * Updates the snake's position based on the player's input direction.
   * If the move is valid, it updates the grid and checks for food.
   * Ends the game if the snake collides with the walls or itself.
   *
   * @param direction The direction in which to move the snake
   *                  ('w' for up, 's' for down, 'a' for left, 'd' for right).
   */
  public static void moveSnake(char direction) {
    // TODO: Implement a switch statement to handle the direction

    // check if the move is valid, if not, the game ends
  }

  /**
   * Generates a food item at a random empty position on the grid.
   */
  public static void generateFood() {
  }

  public static void main(String[] args) {

    initializeGame();
    displayGrid();

    // TODO: Create a scanner for input

    // TODO: Create a game loop that continues until the game is over

    // TODO: Close the scanner before exiting the game
  }
}