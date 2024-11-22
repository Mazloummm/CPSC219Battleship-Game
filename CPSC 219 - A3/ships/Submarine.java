package ships;

// Submarine class that extends Ship
public class Submarine extends Ship {
    public Submarine(int startX, int startY, boolean horizontal) {
        super(startX, startY, horizontal, 3, 'S'); // Size 3 for Submarine
    }

    @Override
    public String getName() {
        return "Submarine";
    }
}
