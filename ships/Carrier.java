package ships;

public class Carrier extends Ship {
    private int hits;

    public Carrier(String name, int startX, int startY, boolean horizontal) {
        super(name, startX, startY, 5, horizontal); // Assuming Carrier size is 5
        this.hits = 0;  // Initialize the number of hits to 0
    }

    @Override
    public void hit(int x, int y) {
        hits++;  // Increment the number of hits
        // You can add more complex logic if needed, like tracking specific coordinates
    }

    @Override
    public boolean isSunk() {
        return hits >= getSize();  // Sunk when hits equal or exceed the size of the ship
    }
}
