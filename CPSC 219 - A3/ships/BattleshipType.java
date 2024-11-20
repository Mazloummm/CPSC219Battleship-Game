package ships;

public enum BattleshipType {
    BATTLESHIP,
    SUBMARINE,
    PATROL_BOAT,
    CARRIER;

    public static BattleshipType fromString(String type) {
        switch (type.toUpperCase()) {
            case "BATTLESHIP":
                return BATTLESHIP;
            case "SUBMARINE":
                return SUBMARINE;
            case "PATROL_BOAT":
                return PATROL_BOAT;
            case "CARRIER":
                return CARRIER;
            default:
                throw new IllegalArgumentException("Unknown battleship type: " + type);
        }
    }
}
