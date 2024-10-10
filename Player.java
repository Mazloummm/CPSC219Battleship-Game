import java.util.List;

import ships.Ship;

public abstract class Player {
    protected String name;
    protected Board board;
    protected List<Ship> ships;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public abstract void placeShips();

    public abstract int[] makeGuess();
}
