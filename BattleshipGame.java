import ships.*;  // Import all ships classes

public class BattleshipGame {

    public static void main(String[] args) {
        // Initialize boards
        Board player1Board = new Board(10); // Assuming a 10x10 grid
        Ship[] computerShips = ConfigFileReader.readConfigFile("data/config.txt"); // Reads config for computer player

        // Create computer board
        Board compBoard = new Board(10); // Create a new board for the computer player
        for (Ship ship : computerShips) {
            if (ship != null) {
                compBoard.placeShip(ship); // Place each ship on the computer's board
            }
        }

        // Initialize players
        HumanPlayer player1 = new HumanPlayer("Player 1", player1Board);
        ComputerPlayer compPlayer = new ComputerPlayer("Computer", compBoard);

        // Place Player 1's ships
        player1.placeShips();

        // Start the game loop
        boolean gameOver = false;
        while (!gameOver) {
            // Player 1's turn
            System.out.println("Player 1's turn:");
            int[] guess = player1.makeGuess();
            boolean hit = compPlayer.getBoard().receiveGuess(guess[0], guess[1]);
            if (hit) {
                System.out.println("Player 1 hit!");
            } else {
                System.out.println("Player 1 missed.");
            }

            // Display the computer's board after Player 1's turn
            System.out.println("Computer's board after Player 1's turn:");
            compPlayer.getBoard().displayBoard();

            // Check if Computer's ships are all sunk
            if (compPlayer.getBoard().allShipsSunk()) {
                System.out.println("Player 1 wins!");
                gameOver = true;
                break; // Break to avoid unnecessary turns
            }

            // Computer's turn
            System.out.println("Computer's turn:");
            int[] computerGuess = compPlayer.makeGuess();
            hit = player1Board.receiveGuess(computerGuess[0], computerGuess[1]);
            if (hit) {
                System.out.println("Computer hit your ship!");
            } else {
                System.out.println("Computer missed.");
            }

            // Display Player 1's board after Computer's turn
            System.out.println("Player 1's board after Computer's turn:");
            player1Board.displayBoard();

            // Check if Player 1's ships are all sunk
            if (player1Board.allShipsSunk()) {
                System.out.println("Computer wins!");
                gameOver = true;
            }
        }

        System.out.println("Game over!");
    }
}
