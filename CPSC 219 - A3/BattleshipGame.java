 public class BattleshipGame {
    public static void main(String[] args) {
        // Initialize boards
        Board player1Board = new Board(10); // Assuming a 10x10 grid
        Board compBoard = new Board(10); // Assuming a 10x10 grid

        // Initialize players
        HumanPlayer player1 = new HumanPlayer("Player 1", player1Board);
        ComputerPlayer comPlayer = new ComputerPlayer("Computer", compBoard);

        // Place ships on the boards
        player1.placeShips();
        comPlayer.placeShips();

        // Start the game loop
        boolean gameOver = false;
        while (!gameOver) {
            // Player 1's turn
            System.out.println("Player 1's turn:");
            int[] guess = player1.makeGuess(); // Get guess from Player 1
            boolean hit = compBoard.receiveGuess(guess[0], guess[1]); // Check if it's a hit
            if (hit) {
                System.out.println("Player 1 hit!"); // Display hit message
                comPlayer.recordHit(guess[0], guess[1]); // Record hit on tracking board
            } else {
                System.out.println("Player 1 missed."); // Display miss message
                comPlayer.recordMiss(guess[0], guess[1]); // Record miss on tracking board
            }

            // Display the computer's board after Player 1's turn
            System.out.println("The computer's board after Player 1's turn:");
            char[][] TrackCPU = comPlayer.getTrackingCBoard();
            comPlayer.displayTrackingCBoard(TrackCPU);

            // Check if Computer's ships are all sunk
            if (comPlayer.getBoard().allShipsSunk()) {
                System.out.println("Player 1 wins!");
                gameOver = true;
                break; // Break to avoid unnecessary turns
            }

            // Computer's turn
            System.out.println("Computer's turn:");
            int[] computerGuess = comPlayer.makeGuess(); // Get guess from Computer
            hit = player1Board.receiveGuess(computerGuess[0], computerGuess[1]); // Check if it's a hit
            if (hit) {
                System.out.println("Computer hit your ship!"); // Display hit message
            } else {
                System.out.println("Computer missed."); // Display miss message
            }

            // Display Player 1's board after Computer's turn
            System.out.println("Player 1's board after Computer's turn:");
            player1.displayGameBoard();

            // Check if Player 1's ships are all sunk
            if (player1Board.allShipsSunk()) {
                System.out.println("Computer wins!");
                gameOver = true;
            } else {
                System.out.println("Next turn...");
            }
        }

        System.out.println("Game over!");
    }
}
