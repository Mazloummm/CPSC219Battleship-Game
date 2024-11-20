/**
 * Represents a coordinate on a 2D grid.
 */
public class Coordinate {

    private int x; // x-coordinate
    private int y; // y-coordinate

    // Constructor to initialize x and y coordinates
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter for x-coordinate
    public int getX() {
        return x;
    }

    // Getter for y-coordinate
    public int getY() {
        return y;
    }

    // Override equals() method to compare two coordinates
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) obj;
        return x == that.x && y == that.y;
    }

    // Override toString() method for a string representation of the coordinate
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
