import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CoordinateTest {

    @Test
    public void testEqualityOfIdenticalCoordinates() {
        Coordinate coord1 = new Coordinate(5, 10);
        Coordinate coord2 = new Coordinate(5, 10);
        assertTrue(coord1.equals(coord2));
    }

    @Test
    public void testInequalityOfDifferentCoordinates() {
        Coordinate coord1 = new Coordinate(5, 10);
        Coordinate coord2 = new Coordinate(10, 5);
        assertFalse(coord1.equals(coord2));
    }

    @Test
    public void testEqualityWithNull() {
        Coordinate coord1 = new Coordinate(5, 10);
        assertFalse(coord1.equals(null));
    }

    @Test
    public void testEqualityWithDifferentClass() {
        Coordinate coord1 = new Coordinate(5, 10);
        String notACoordinate = "Not a Coordinate";
        assertFalse(coord1.equals(notACoordinate));
    }

    @Test
    public void testToString() {
        Coordinate coord1 = new Coordinate(5, 10);
        assertEquals("(5, 10)", coord1.toString());
    }

    @Test
    public void testGetX() {
        Coordinate coord1 = new Coordinate(5, 10);
        assertEquals(5, coord1.getX());
    }

    @Test
    public void testGetY() {
        Coordinate coord1 = new Coordinate(5, 10);
        assertEquals(10, coord1.getY());
    }
}