package ships;

public class ShipFactory {

    public static Ship createShip(BattleshipType type, int startX, int startY, boolean horizontal) {
        switch (type) {
            case BATTLESHIP:
                return new Battleship("Battleship", startX, startY, horizontal);
            case SUBMARINE:
                return new Submarine("Submarine", startX, startY, horizontal);
            case PATROL_BOAT:
                return new PatrolBoat("Patrol Boat", startX, startY, horizontal);
            case CARRIER:
                return new Carrier("Carrier", startX, startY, horizontal);
            default:
                throw new IllegalArgumentException("Unknown ship type: " + type);
        }
    }
}
