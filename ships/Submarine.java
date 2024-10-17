package ships;

public class Submarine extends Ship {
    private int hits;

    public Submarine(String name, int startX, int startY, boolean horizontal) {
        super(name, startX, startY, 3, horizontal); // Assuming Submarine size is 3
        this.hits = 0;  // Initialize the number of hits to 0
    }

    @Override
    public void hit(int x, int y) {
        hits++;  // Increment the number of hits
        // Add more logic as needed
    }

    @Override
    public boolean isSunk() {
        return hits >= getSize();  // Sunk when hits equal or exceed the size of the ship
    }
}
