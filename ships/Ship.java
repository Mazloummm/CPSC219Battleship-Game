package ships;

public abstract class Ship {
    private String name;
    private int startX;
    private int startY;
    private int size;
    private boolean horizontal;

    public Ship(String name, int startX, int startY, int size, boolean horizontal) {
        this.name = name;
        this.startX = startX;
        this.startY = startY;
        this.size = size;
        this.horizontal = horizontal;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    // Setters
    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    // Define other methods as required
    public abstract void hit(int x, int y);

    public abstract boolean isSunk();
}
