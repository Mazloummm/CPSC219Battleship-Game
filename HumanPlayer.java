import java.util.Scanner;
import ships.Ship;
import ships.Battleship;
import ships.PatrolBoat;
import ships.Submarine;
import ships.Carrier;

public class HumanPlayer extends Player {

    private Scanner scanner = new Scanner(System.in);
    private char[][] trackingBoard; // Board for tracking hits and misses

    public HumanPlayer(String name, Board board) {
        super(name, board);
        this.trackingBoard = new char[board.getSize()][board.getSize()];
        initializeTrackingBoard();
    }

    @Override
    public void placeShips() {
        System.out.println(name + ", it's time to place your ships!");
        displayGameBoard();

        Ship[] shipsToPlace = {
            new Battleship(0, 0, true),
            new PatrolBoat(0, 0, true),
            new Submarine(0, 0, true),
            new Carrier(0, 0, true)
        };

        for (Ship ship : shipsToPlace) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Place " + ship.getName() + " (length " + ship.getSize() + "): ");
                int startX = getCoordinate("Enter starting x-coordinate (0 to " + (board.getSize() - 1) + "): ");
                int startY = getCoordinate("Enter starting y-coordinate (0 to " + (board.getSize() - 1) + "): ");
                boolean horizontal = getHorizontalPlacement();

                ship.setStartX(startX);
                ship.setStartY(startY);
                ship.setHorizontal(horizontal);

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

    private void displayGameBoard() {
        System.out.println("Game Board:");
        char[][] gameBoard = board.getBoard(); // Assuming your Board class has a method to get the game board

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print("[" + gameBoard[i][j] + "]");
            }
            System.out.println();
        }
    }

    private void initializeTrackingBoard() {
        for (int i = 0; i < trackingBoard.length; i++) {
            for (int j = 0; j < trackingBoard[i].length; j++) {
                trackingBoard[i][j] = ' '; // Initialize with empty spaces
            }
        }
    }

    public void recordHit(int x, int y) {
        trackingBoard[x][y] = 'X'; // Mark a hit
    }

    public void recordMiss(int x, int y) {
        trackingBoard[x][y] = 'O'; // Mark a miss
    }

    public void displayTrackingBoard() {
        System.out.println("Tracking Board:");
        for (int i = 0; i < trackingBoard.length; i++) {
            for (int j = 0; j < trackingBoard[i].length; j++) {
                System.out.print("[" + trackingBoard[i][j] + "]");
            }
            System.out.println();
        }
    }

    private int getCoordinate(String prompt) {
        int coordinate;
        while (true) {
            System.out.print(prompt);
            coordinate = scanner.nextInt();
            if (coordinate >= 0 && coordinate < board.getSize()) {
                return coordinate;
            } else {
                System.out.println("Invalid coordinate. Please enter a value between 0 and " + (board.getSize() - 1) + ".");
            }
        }
    }

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

    @Override
    public int[] makeGuess() {
        int guessX = getCoordinate("Enter x-coordinate for your guess (0 to " + (board.getSize() - 1) + "): ");
        int guessY = getCoordinate("Enter y-coordinate for your guess (0 to " + (board.getSize() - 1) + "): ");
        return new int[]{guessX, guessY};
    }
}
