import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import ships.*;

public class ConfigFileReader {
    /**
     * Reads a configuration file and creates an array of Ship objects based on the file contents.
     * The configuration file should contain one line per ship, with the following format:
     *                              <ShipType> <x> <y> <H/V>
     * where <ShipType> is the type of ship (Battleship, Carrier, Submarine, PatrolBoat),
     * <x> and <y> are the starting coordinates of the ship, and <H/V> indicates whether the ship is placed horizontally or vertically
     * @param filename the name of the configuration file to read
     * @return an array of Ship objects based on the configuration file
     */
    public static Ship[] readConfigFile(String filename) {
        Ship[] ships = new Ship[4]; // Adjust size based on the number of ships
        File file = new File(filename);
        BufferedReader br = null;
        // Check if file exists and can be read
        if (file.exists() && file.isFile() && file.canRead()) {
            try { // Try to read the configuration file
                FileReader fileReader = new FileReader(file); // Open the configuration file
                br = new BufferedReader(fileReader);
                String line;
                int index = 0;
                // Read each line in the configuration file
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ");
                    String shipType = parts[0]; // Get ship type
                    int x = Integer.parseInt(parts[1]); // Convert string to integer
                    int y = Integer.parseInt(parts[2]); 
                    boolean horizontal = parts[3].equalsIgnoreCase("H"); // Check if ship is horizontal

                    // Create Ship object based on ship type
                    switch (shipType) {
                        case "Battleship":
                            ships[index++] = new Battleship(x, y, horizontal);
                            break;
                        case "Carrier":
                            ships[index++] = new Carrier(x, y, horizontal);
                            break;
                        case "Submarine":
                            ships[index++] = new Submarine(x, y, horizontal);
                            break;
                        case "PatrolBoat":
                            ships[index++] = new PatrolBoat(x, y, horizontal);
                            break;
                    }
                }
            } catch (IOException e) { // Catch any exceptions
                System.out.println("Error reading configuration file: " + e.getMessage());
            } finally { // Close the BufferedReader
                try {
                    br.close(); 
                } catch (IOException e) { // Catch any exceptions when closing the file
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        } else { // File cannot be read
            System.out.println("File not found or cannot be read.");
            System.exit(1); // Exit the program
        } return ships;
    }
}
