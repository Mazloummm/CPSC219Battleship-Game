import ships.*;

public class Board {
    // Instance variables
    private char[][] grid;
    private final int size;

    // Constructor to create a board of a given size
    public Board(int size) {
        this.size = size;
        grid = new char[size][size];

        // Initialize the grid with empty cells
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean placeShip(Ship ship) {
        int startX = ship.getStartX();
        int startY = ship.getStartY();
        int length = ship.getSize();
        
        // Check if the ship can be placed
        if (isPlacementValid(startX, startY, length, ship.isHorizontal())) {
            for (int i = 0; i < length; i++) {
                if (ship.isHorizontal()) {
                    grid[startY][startX + i] = ship.getIdentifier();
                } else {
                    grid[startY + i][startX] = ship.getIdentifier();
                }
            }
            return true; // Ship placed successfully
        }
        return false; // Ship cannot be placed
    }

    public boolean isPlacementValid(int startX, int startY, int length, boolean horizontal) {
        if (horizontal) {
            if (startX + length > size) return false; // Out of bounds horizontally
            for (int i = 0; i < length; i++) {
                if (grid[startY][startX + i] != ' ') return false; // Cell already occupied
            }
        } else {
            if (startY + length > size) return false; // Out of bounds vertically
            for (int i = 0; i < length; i++) {
                if (grid[startY + i][startX] != ' ') return false; // Cell already occupied
            }
        }
        return true; // Valid placement
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("[");
                // Display hit, miss, or empty cell
                char cell = grid[i][j];
                if (cell == 'X') {
                    System.out.print('X'); // Hit
                } else if (cell == 'O') {
                    System.out.print('O'); // Miss
                } else {
                    System.out.print(cell); // Empty or ship part
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public void markHit(int x, int y) {
        if (grid[y][x] != ' ' && grid[y][x] != 'X' && grid[y][x] != 'O') {
            grid[y][x] = 'X'; // Mark as hit
        } else {
            grid[y][x] = 'O'; // Mark as miss
        }
    }

    public boolean receiveGuess(int x, int y) {
        boolean hit = grid[y][x] != ' '; // Check if there is a ship here
        markHit(x, y);
        return hit; // Return true if it was a hit
        }

        // Check if all ships are sunk
        public boolean allShipsSunk() {
        // Iterate through the grid
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                char cell = grid[i][j];
                // If any ship parts are found, return false
                if (cell == 'S' || cell == 'B' || cell == 'P' || cell == 'C') {
                    return false; // Found a part of a ship
                }
                }
            }
            return true; // All ships are sunk
        }

        public void displayInitialBoard() {
        System.out.println("The game board is a " + size + "x" + size + " grid, each cell represented by square brackets []. The grid is used to place ships and make guesses. Each cell can either be empty, contain part of a ship, or be marked as a hit or miss.");
        System.out.println("This is what the empty game board looks like before ships have been placed:");
        displayBoard();
        
        System.out.println("IDENTIFIERS FOR SHIPS:");
        System.out.println("Ships: Ships are represented by their identifiers in the cells they occupy.");
        System.out.println("• Battleship (B)");
        System.out.println("• Carrier (C)");
        System.out.println("• Submarine (S)");
        System.out.println("• Patrol Boat (P)");
    }
    
    // Display a sample board for the human player to see when placing ships
    public void displaySampleBoard() {
        // Example of a filled board for display
        char[][] sampleBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'S', 'S', 'S', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'B', 'B', 'B', 'B', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', 'P', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', 'P', 'C', 'C', 'C', 'C', 'C'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        
        System.out.println("Here is a sample board that the human player will see when placing their own ships:");
        for (char[] row : sampleBoard) {
            System.out.print("[");
            for (char cell : row) {
                System.out.print(cell);
                System.out.print("]");
            }
            System.out.println();
        }
    }
    public char[][] getBoard() {
        return grid; // Return the current state of the board
    }
    
}