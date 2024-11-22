import java.util.List;

import ships.*;

public abstract class Player {
    protected String name; // Player's name
    protected Board board; // Player's game board
    protected List<Ship> ships; // List of ships

    public Player(String name, Board board) {
        this.name = name; // Set player's name
        this.board = board; // Set player's game board
    }

    public String getName() {
        return name; // Return player's name
    }

    public Board getBoard() {
        return board; // Return player's game board
    }

    public abstract void placeShips(); // Abstract method to place ships

    public abstract int[] makeGuess(); // Abstract method to make a guess
}
