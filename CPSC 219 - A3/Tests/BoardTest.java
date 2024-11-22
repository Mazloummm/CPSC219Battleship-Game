package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ships.Battleship;
import ships.Carrier;
import ships.Submarine;
import ships.PatrolBoat;
import Board;

public class BoardTest {

    @Test
    public void testPlaceShipWithinBoundaries() {
        Board board = new Board(10);
        Ship battleship = new Battleship(0, 0, true);
        assertTrue(board.placeShip(battleship));
    }

    @Test
    public void testPlaceShipOutsideBoundaries() {
        Board board = new Board(10);
        Ship battleship = new Battleship(9, 9, true);
        assertFalse(board.placeShip(battleship));
    }

    @Test
    public void testPlaceShipOverlap() {
        Board board = new Board(10);
        Ship battleship1 = new Battleship(0, 0, true);
        Ship battleship2 = new Battleship(0, 0, true);
        assertTrue(board.placeShip(battleship1));
        assertFalse(board.placeShip(battleship2));
    }

    @Test
    public void testIsOccupied() {
        Board board = new Board(10);
        Ship battleship = new Battleship(0, 0, true);
        board.placeShip(battleship);
        assertTrue(board.isOccupied(0, 0));
        assertFalse(board.isOccupied(1, 1));
    }

    @Test
    public void testIsOccupied() {
        Board board = new Board(10);
        Ship battleship = new Battleship(0, 0, true);
        board.placeShip(battleship);
        assertTrue(board.isOccupied(0, 0));
        assertFalse(board.isOccupied(1, 1));
    }

}
