// Objective: Implent a snake game in java
public class SnakeGame {
    // Constants declared
public static final int Grid_Width = 20;    // Width of row
public static final int Grid_Height = 10;  // Height of column
public static final int Max_Snake_Length = 100;
public static final char Snake_Char = 'S'; // Snake on the grid
public static final char Food_Char = '@'; // FOod on the grid
public static final char Empty_Char = '.'; // Empty space of the grid
public static final char Wall_Char = '#'; // Wall of the grid



public static char[][] grid; // The game space grid

// Initialize the grid

public static void initializeGrid() {
    grid = new char[Grid_Height][Grid_Width];
    for (int y = 0; y < Grid_Height; y++) {
        for (int x = 0; x < Grid_Width; x++) {
            if (y == 0 || y == Grid_Height-1 || x == 0 || x == Grid_Width-1) {
                grid[y][x] = Wall_Char;               
            } else {
                grid[y][x] = Empty_Char;
            }

            
        }
    }

}

public static void displayGrid() {
    for (int y = 0; y < Grid_Height; y++) {
        for (int x = 0; x < Grid_Width; x++) {
            System.out.print(grid[y][x]); // Print each cell without newline
        }
        System.out.println(); // Newline after each row
    }
}


public static void main(String[] args) {
    initializeGrid();
    displayGrid();
}


}
