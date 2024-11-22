import java.util.Random;
import ships.*;

public class ComputerPlayer extends Player {
    // Instance variables
    private Random random; // Random number generator for making guesses
    private int ships; // Number of remaining ships
    private char[][] trackingCBoard; // Board for tracking hits and misses

    /**
     * Constructs a new ComputerPlayer object with the given name and board.
     *
     * @param name The name of the computer player.
     * @param board The game board for the computer player.
     */
    public ComputerPlayer(String name, Board board) {
        super(name, board);
        this.random = new Random();
        this.trackingCBoard = new char[board.getSize()][board.getSize()]; // Initial number of ships (or set based on configuration)
        initializeTrackingCBoard();
    }

    /**
     * Places the computer player's ships on the board.
     */
    @Override
    public void placeShips() {
        // Array of ships to place from configuration file
        Ship[] shipsToPlace = ConfigFileReader.readConfigFile("config.txt");
        Board compBoard = getBoard();
        // Place each ship on the board
        for (Ship ship : shipsToPlace) {
            boolean placed = false;
            while (!placed) {
                // Check if ship can be placed
                if (compBoard.placeShip(ship)) {
                    placed = true;
                } else { // Ship cannot be placed
                    System.out.println("Check configuration file for valid ship placement.");
                }
            }
        }
            
    }

    // Display the tracking board for the computer
    public void displayTrackingCBoard(char[][] trackingCBoard) {
        for (int i = 0; i < trackingCBoard.length; i++) {
            for (int j = 0; j < trackingCBoard[i].length; j++) {
                // Display the tracking board
                System.out.print("[" + trackingCBoard[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Get the tracking board for the computer
    public char[][] getTrackingCBoard() {
        return trackingCBoard;
    }

    // Initialize the tracking board with empty spaces
    private void initializeTrackingCBoard() {
        for (int i = 0; i < trackingCBoard.length; i++) {
            for (int j = 0; j < trackingCBoard[i].length; j++) {
                trackingCBoard[i][j] = ' '; // Initialize tracking board with empty spaces
            } 
        }
    }

    // Record a hit on the tracking board
    public void recordHit(int x, int y) {
        trackingCBoard[y][x] = 'X'; // Mark a hit
    }

    // Record a miss on the tracking board
    public void recordMiss(int x, int y) {
        trackingCBoard[y][x] = 'O'; // Mark a miss
    }

    /**
     * Makes a random guess on the board.
     * If the computer makes a correct guess, it should attempt to guess an adjacent square.
     *
     * @return An array containing the x and y coordinates of the guess.
     */
    @Override
    public int[] makeGuess() {
        int x = random.nextInt(board.getSize());
        int y = random.nextInt(board.getSize());
        return new int[]{x, y}; // Return the guess
    }

    /**
     * Returns the number of remaining ships.
     * 
     * @return The count of remaining ships.
     */
    public int getRemainingShips() {
        return ships; // Return the count of remaining ships
    }
}
