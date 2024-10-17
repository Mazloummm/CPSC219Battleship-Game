import java.util.Scanner;
import ships.Ship;
import ships.Battleship; // Add this line
import ships.PatrolBoat; // Add this line


public class HumanPlayer extends Player {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new HumanPlayer object with the given name and board.
     *
     * @param name The name of the human player.
     * @param board The game board for the human player.
     */
    public HumanPlayer(String name, Board board) {
        super(name, board);
    }

    /**
     * Places the human player's ships on the board.
     */
    @Override
    public void placeShips() {
        System.out.println(name + ", it's time to place your ships!");

        // Example of ship types, you can expand this as needed
        Ship[] shipsToPlace = {
            new Battleship("Battleship 1", 0, 0, true),
            new PatrolBoat("PatrolBoat 1", 0, 0, true)
        };

        for (Ship ship : shipsToPlace) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Place " + ship.getName() + " (length " + ship.getSize() + "): ");
                System.out.print("Enter starting x-coordinate (0 to " + (board.getSize() - 1) + "): ");
                int startX = scanner.nextInt();

                System.out.print("Enter starting y-coordinate (0 to " + (board.getSize() - 1) + "): ");
                int startY = scanner.nextInt();

                System.out.print("Place horizontally? (true/false): ");
                boolean horizontal = scanner.nextBoolean();

                // Update ship's position and try to place it
                ship.setStartX(startX);
                ship.setStartY(startY);
                ship.setHorizontal(horizontal);

                if (board.placeShip(ship)) {
                    placed = true;
                    System.out.println(ship.getName() + " placed successfully!");
                } else {
                    System.out.println("Cannot place ship here. Please try again.");
                }
            }
        }
    }

    /**
     * Makes a guess based on user input.
     *
     * @return An array containing the x and y coordinates of the guess.
     */
    @Override
    public int[] makeGuess() {
        System.out.print("Enter x-coordinate for your guess (0 to " + (board.getSize() - 1) + "): ");
        int guessX = scanner.nextInt();

        System.out.print("Enter y-coordinate for your guess (0 to " + (board.getSize() - 1) + "): ");
        int guessY = scanner.nextInt();

        return new int[]{guessX, guessY};
    }
}
