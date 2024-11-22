package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import HumanPlayer;
import Board;

public class HumanPlayerTest {

    private HumanPlayer humanPlayer;
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(10); // Assuming a 10x10 board
        humanPlayer = new HumanPlayer(board, new Scanner(System.in));
    }

    @Test
    public void testGetCoordinateValid() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        humanPlayer.setScanner(new Scanner(System.in)); // Update the scanner with the new input stream
        int coordinate = humanPlayer.getCoordinate("Enter coordinate: ");
        assertEquals(5, coordinate);
    }

    @Test
    public void testGetCoordinateInvalidThenValid() {
        String input = "-1\n11\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        humanPlayer.setScanner(new Scanner(System.in)); // Update the scanner with the new input stream
        int coordinate = humanPlayer.getCoordinate("Enter coordinate: ");
        assertEquals(5, coordinate);
    }

    @Test
    public void testGetCoordinateNonIntegerInput() {
        String input = "abc\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        humanPlayer.setScanner(new Scanner(System.in)); // Update the scanner with the new input stream
        int coordinate = humanPlayer.getCoordinate("Enter coordinate: ");
        assertEquals(5, coordinate);
    }
}