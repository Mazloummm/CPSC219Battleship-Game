package ships;

public class ShipFactory {

    public static Ship createShip(String shipType, int startX, int startY, boolean horizontal) {
        switch (shipType.toLowerCase()) {
            case "battleship":
                return new Battleship(startX, startY, horizontal);
            case "submarine":
                return new Submarine(startX, startY, horizontal);
            case "patrolboat":
                return new PatrolBoat(startX, startY, horizontal);
            case "carrier":
                return new Carrier(startX, startY, horizontal);
            default:
                throw new IllegalArgumentException("Unknown ship type: " + shipType);
        }
    }
}
