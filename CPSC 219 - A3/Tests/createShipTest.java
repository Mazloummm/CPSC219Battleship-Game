package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ships.*;

public class createShipTest {

    @Test
    public void testCreateBattleship() {
        Ship ship = ShipFactory.createShip("battleship", 0, 0, true);
        assertNotNull(ship);
        assertTrue(ship instanceof Battleship);
        assertEquals("Battleship", ship.getName());
    }

    @Test
    public void testCreateSubmarine() {
        Ship ship = ShipFactory.createShip("submarine", 1, 1, false);
        assertNotNull(ship);
        assertTrue(ship instanceof Submarine);
        assertEquals("Submarine", ship.getName());
    }

    @Test
    public void testCreatePatrolBoat() {
        Ship ship = ShipFactory.createShip("patrolboat", 2, 2, true);
        assertNotNull(ship);
        assertTrue(ship instanceof PatrolBoat);
        assertEquals("PatrolBoat", ship.getName());
    }

    @Test
    public void testCreateCarrier() {
        Ship ship = ShipFactory.createShip("carrier", 3, 3, false);
        assertNotNull(ship);
        assertTrue(ship instanceof Carrier);
        assertEquals("Carrier", ship.getName());
    }

    @Test
    public void testCreateUnknownShipType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ShipFactory.createShip("unknown", 4, 4, true);
        });
        assertEquals("Unknown ship type: unknown", exception.getMessage());
    }
}
