package ships;

// Ship class that represents a ship in the game
public abstract class Ship {
    protected int startX;
    protected int startY;
    protected boolean horizontal;
    protected int size;
    protected char identifier;

    // Constructor
    public Ship(int startX, int startY, boolean horizontal, int size, char identifier) {
        this.startX = startX;
        this.startY = startY;
        this.horizontal = horizontal;
        this.size = size;
        this.identifier = identifier;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public int getSize() {
        return size;
    }

    public char getIdentifier() {
        return identifier;
    }
    
    // Abstract method to get the ship name
    public abstract String getName();
}