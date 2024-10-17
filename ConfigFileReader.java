import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ships.Ship;
import ships.PatrolBoat; // Import your specific Ship subclasses here

/**
 * Reads a configuration file and creates a board with the ships specified in the file.
 */
public class ConfigFileReader {

    /**
     * Parses a configuration file and creates a board with the ships specified in the file.
     *
     * @param filename The name of the configuration file.
     * @return A Board object with the ships placed according to the configuration file.
     */
    public static Board parseBoard(String filename) {
        Board board = new Board();
        List<Ship> ships = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String shipType = parts[0]; // The type of the ship
                String identifier = parts[1]; // Ship identifier (name)
                int startX = Integer.parseInt(parts[2]); // Starting X coordinate
                int startY = Integer.parseInt(parts[3]); // Starting Y coordinate
                boolean horizontal = Boolean.parseBoolean(parts[4]); // Orientation

                // Create ship based on type
                Ship ship = createShip(shipType, identifier, startX, startY, horizontal);
                if (ship != null) {
                    if (board.placeShip(ship)) {
                        ships.add(ship); // Only add the ship if it was placed successfully
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return board; // Return the board with placed ships
    }

    /**
     * Creates a ship based on the ship type.
     *
     * @param shipType The type of the ship (e.g., "PatrolBoat").
     * @param identifier The identifier for the ship.
     * @param startX The starting X coordinate for the ship.
     * @param startY The starting Y coordinate for the ship.
     * @param horizontal Whether the ship is placed horizontally or vertically.
     * @return The created Ship object or null if the ship type is unrecognized.
     */
    private static Ship createShip(String shipType, String identifier, int startX, int startY, boolean horizontal) {
        switch (shipType) {
            case "PatrolBoat":
                return new PatrolBoat(identifier, startX, startY, horizontal);
            // Add other ship types here as needed
            default:
                return null; // Return null for unrecognized ship types
        }
    }
}
