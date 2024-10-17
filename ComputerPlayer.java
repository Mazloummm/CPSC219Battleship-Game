import java.util.Random;

/**
 * Represents a computer player in the Battleship game.
 */
public class ComputerPlayer extends Player {
    private Random random; // Random number generator for making guesses
    private int ships; // Number of remaining ships

    /**
     * Constructs a new ComputerPlayer object with the given name and board.
     *
     * @param name The name of the computer player.
     * @param board The game board for the computer player.
     */
    public ComputerPlayer(String name, Board board) {
        super(name, board);
        this.random = new Random();
        this.ships = 5; // Initial number of ships (or set based on configuration)
    }

    /**
     * Places the computer player's ships on the board.
     */
    @Override
    public void placeShips() {
        // Implement logic to place ships randomly
        // You can call the placeShip method from Board here
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
