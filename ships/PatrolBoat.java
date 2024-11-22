package ships;

// PatrolBoat class that extends Ship
public class PatrolBoat extends Ship {
    public PatrolBoat(int startX, int startY, boolean horizontal) {
        super(startX, startY, horizontal, 2, 'P'); // Size 2 for Patrol Boat
    }

    @Override
    public String getName() {
        return "Patrol Boat";
    }
}