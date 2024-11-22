public class Coordinate {
    // Instance variables
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
        // Check if the object is compared with itself
        if (this == obj) {
            return true;
        } // Check if the object is null or of different class
        else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) obj; // Cast the object to a Coordinate
        return x == that.x && y == that.y;
    }

    // Override toString() method for a string representation of the coordinate
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}