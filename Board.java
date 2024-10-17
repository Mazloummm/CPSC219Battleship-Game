import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import ships.Ship;

/**
 * Represents a game board for placing and tracking ships.
 */
public class Board {
    private Map<Coordinate, Ship> grid;
    private List<Ship> ships;
    private static final int size = 10;  // The size of the board (10x10)

    /**
     * Constructs a new Board object with an empty grid and no ships.
     */
    public Board() {
        grid = new HashMap<>();  // Initializes an empty map to represent the grid
        ships = new ArrayList<>();  // Initializes an empty list of ships
    }

    /**
     * Places a ship on the board if it can be placed without overlapping with other ships.
     *
     * @param ship The ship to be placed on the board.
     * @return true if the ship was successfully placed, false otherwise.
     */
    public boolean placeShip(Ship ship) {
        int x = ship.getStartX();
        int y = ship.getStartY();
        int length = ship.getSize();
        boolean horizontal = ship.isHorizontal();

        // Check if the ship can be placed without overlapping
        if (!canPlaceShip(x, y, length, horizontal)) {
            return false;
        }

        // Place the ship on the grid
        for (int i = 0; i < length; i++) {
            Coordinate coord = horizontal ? new Coordinate(x + i, y) : new Coordinate(x, y + i);
            grid.put(coord, ship);  // Map the coordinate to the ship
        }
        
        ships.add(ship);  // Add the ship to the list of ships on the board
        return true;
    }

    /**
     * Checks if a ship can be placed on the board without overlapping with other ships.
     *
     * @param x The x-coordinate of the ship's starting position.
     * @param y The y-coordinate of the ship's starting position.
     * @param length The length of the ship.
     * @param horizontal Whether the ship is placed horizontally or vertically.
     * @return true if the ship can be placed without overlapping, false otherwise.
     */
    private boolean canPlaceShip(int x, int y, int length, boolean horizontal) {
        // Check if the ship goes out of bounds
        if (horizontal && (x + length > size)) {
            return false;
        }
        if (!horizontal && (y + length > size)) {
            return false;
        }

        // Check for overlap with other ships
        for (int i = 0; i < length; i++) {
            Coordinate coord = horizontal ? new Coordinate(x + i, y) : new Coordinate(x, y + i);
            if (grid.containsKey(coord)) {
                return false;  // Overlaps with another ship
            }
        }

        return true;
    }

    /**
     * Displays the current state of the board, showing the positions of ships.
     */
    public void displayBoard() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int y = 0; y < size; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < size; x++) {
                Coordinate coord = new Coordinate(x, y);
                if (grid.containsKey(coord)) {
                    System.out.print("S ");  // Display ships (you can change the symbol)
                } else {
                    System.out.print(". ");  // Empty water
                }
            }
            System.out.println();
        }
    }

    /**
     * Receives a guess from the player and checks if it hits a ship.
     * If a ship is hit, it updates the ship's status and prints a message if the ship is sunk.
     *
     * @param x The x-coordinate of the guess.
     * @param y The y-coordinate of the guess.
     * @return true if the guess hits a ship, false otherwise.
     */
    // Board.java - In the receiveGuess method, update the hit call
public boolean receiveGuess(int x, int y) {
    Coordinate coord = new Coordinate(x, y);
    if (grid.containsKey(coord)) {
        Ship ship = grid.get(coord);

        // Call hit with x and y coordinates
        ship.hit(x, y);  // Adjusted to pass x and y

        System.out.println("Hit!");
        if (ship.isSunk()) {
            System.out.println("You sank a ship!");
        }
        return true;
    } else {
        System.out.println("Miss!");
        return false;
    }
}

    
    
    /**
 * Gets the size of the board.
 *
 * @return The size of the board.
 */
public int getSize() {
    return size; // Assuming 'size' is a static variable representing the board dimensions
}
public boolean allShipsSunk() {
    for (Ship ship : ships) {
        if (!ship.isSunk()) {
            return false;  // If at least one ship is not sunk, return false
        }
    }
    return true;  // All ships are sunk
}


}
