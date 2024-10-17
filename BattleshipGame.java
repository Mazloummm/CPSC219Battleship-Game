
public class BattleshipGame {
    

    public static void main(String[] args) {
        // Read configuration file and create the board
        Board compBoard = ConfigFileReader.parseBoard("data/config.txt");
        ComputerPlayer compPlayer = new ComputerPlayer("Computer", compBoard);

        // Initialize Player 1's board
        Board player1Board = new Board();
        HumanPlayer player1 = new HumanPlayer("Player 1", player1Board);

        // Place Player 1 ships manually
        player1.placeShips();

        // Start the game loop
        boolean gameOver = false;
        while (!gameOver) {
            // Player 1's turn
            System.out.println("Player 1's turn:");
            int[] guess = player1.makeGuess();
            boolean hit = compPlayer.getBoard().receiveGuess(guess[0], guess[1]);
            if (hit) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss.");
            }

            // Check for game over conditions
            if (compPlayer.getBoard().allShipsSunk()) {
                System.out.println("Player 1 wins!");
                gameOver = true;
                break;
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

            // Check for game over conditions
            if (player1Board.allShipsSunk()) {
                System.out.println("Computer wins!");
                gameOver = true;
            }
        }

        System.out.println("Game over!");
    }
}

