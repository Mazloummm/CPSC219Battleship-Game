import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ships.*;

public class ConfigFileReader {
    public static Ship[] readConfigFile(String filename) {
        Ship[] ships = new Ship[4]; // Adjust size based on the number of ships
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String shipType = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                boolean horizontal = parts[3].equalsIgnoreCase("H");

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
        } catch (IOException e) {
            System.out.println("Error reading configuration file: " + e.getMessage());
        }
        return ships;
    }
}
