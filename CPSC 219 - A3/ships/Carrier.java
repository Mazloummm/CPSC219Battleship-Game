package ships;

// Carrier class that extends Ship
public class Carrier extends Ship {
    public Carrier(int startX, int startY, boolean horizontal) {
        super(startX, startY, horizontal, 5, 'C'); // Size 5 for Carrier
    }

    @Override
    public String getName() {
        return "Carrier";
    }
}
