package ships;

public class Battleship extends Ship {
    public Battleship(String name, int startX, int startY, boolean horizontal) {
        super(name, startX, startY, 4, horizontal);  // Assuming size 4 for Battleship
    }

    @Override
    public void hit(int x, int y) {
        // Implementation of hit logic
    }

    @Override
    public boolean isSunk() {
        // Implementation to check if the ship is sunk
        return false;
    }
}

