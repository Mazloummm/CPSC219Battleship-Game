import java.util.Scanner;
import ships.*;

public class HumanPlayer extends Player {

    private Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Constructs a new HumanPlayer object with the given name and board.
     *
     * @param name The name of the human player.
     * @param board The game board for the human player.
     */
    public HumanPlayer(String name, Board board) {
        super(name, board); // Call superclass constructor
    }

    /**
     * Places the human player's ships on the board.
     */
    @Override
    public void placeShips() {
        System.out.println(name + ", it's time to place your ships!");
        displayGameBoard(); // Show initial game board before placing ships

        // Array of ships to place
        Ship[] shipsToPlace = {
            new Battleship(0, 0, true), 
            new PatrolBoat(0, 0, true),
            new Submarine(0, 0, true),
            new Carrier(0, 0, true)
        };

        // Place each ship on the board
        for (Ship ship : shipsToPlace) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Place " + ship.getName() + " (length " + ship.getSize() + "): "); // Prompt user to place ship
                int startX = getCoordinate("Enter starting x-coordinate (0 to " + (board.getSize() - 1) + "): "); // Get starting x-coordinate
                int startY = getCoordinate("Enter starting y-coordinate (0 to " + (board.getSize() - 1) + "): "); // Get starting y-coordinate
                boolean horizontal = getHorizontalPlacement(); // Get horizontal placement

                ship.setStartX(startX); // Set starting x-coordinate
                ship.setStartY(startY); // Set starting y-coordinate
                ship.setHorizontal(horizontal); // Set horizontal placement

                // Check if ship can be placed
                if (board.placeShip(ship)) { 
                    placed = true;
                    System.out.println(ship.getName() + " placed successfully!");
                    displayGameBoard(); // Show updated game board after placing a ship
                } else {
                    System.out.println("Cannot place ship here. Please try again.");
                }
            }
        }
    }

    // Display the game board
    public void displayGameBoard() {
        char[][] gameBoard = board.getBoard(); // Assuming your Board class has a method to get the game board

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print("[" + gameBoard[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Coordinate input validation
    public int getCoordinate(String prompt) {
        int coordinate;
        while (true) {
            System.out.print(prompt);
            coordinate = scanner.nextInt();
            // Check if the coordinate is within the board size
            try { 
                if (coordinate >= 0 && coordinate < board.getSize()) {
                    return coordinate;
                // If not, prompt the user to enter a valid coordinate
                } else {
                    System.out.println("Invalid coordinate. Please enter a value between 0 and " + (board.getSize() - 1) + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    // Horizontal placement input validation
    private boolean getHorizontalPlacement() {
        while (true) {
            System.out.print("Place horizontally? (true/false): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("true")) {
                return true;
            } else if (input.equalsIgnoreCase("false")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    }

    // Player's guess input
    @Override
    public int[] makeGuess() {
        int guessX = getCoordinate("Enter x-coordinate for your guess (0 to " + (board.getSize() - 1) + "): ");
        int guessY = getCoordinate("Enter y-coordinate for your guess (0 to " + (board.getSize() - 1) + "): ");
        return new int[]{guessX, guessY};
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }   
}