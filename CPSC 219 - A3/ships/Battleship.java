package ships;

// Battleship class that extends Ship
public class Battleship extends Ship {
    public Battleship(int startX, int startY, boolean horizontal) {
        super(startX, startY, horizontal, 4, 'B'); // Size 4 for Battleship
    }

    @Override
    public String getName() {
        return "Battleship";
    }
}
