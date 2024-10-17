package ships;

public class PatrolBoat extends Ship {
    public PatrolBoat(String name, int startX, int startY, boolean horizontal) {
        super(name, startX, startY, 2, horizontal);  // Assuming size 2 for PatrolBoat
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
