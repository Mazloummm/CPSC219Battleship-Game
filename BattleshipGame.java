// Amr Ibrahim UCID #30219524
// Ethan Stirling UCID #30229189

public class BattleshipGame {
    public static void main(String[] args) {
        // Create dummy boards for testing purposes
        Board compBoard = new Board(); // Dummy board for computer
        Board player1Board = new Board(); // Dummy board for player

        // Create players
        ComputerPlayer compPlayer = new ComputerPlayer("Computer", compBoard);
        HumanPlayer player1 = new HumanPlayer("Player 1", player1Board);

        // For testing, you can manually place ships here or add some basic logic
        // player1.placeShips(); // Uncomment this if you want to use manual placement

        // Start the game loop
        boolean gameOver = false;
        while (!gameOver) {
            // Player 1's turn
            System.out.println("Player 1's turn:");
            boolean player1Turn = true; // Control the player's turn

            while (player1Turn) {
                // Simulate player guess; you can replace this with actual input logic later
                int[] guess = {0, 0}; // Change this to simulate different guesses
                boolean hit = compPlayer.board.receiveGuess(guess[0], guess[1]); // Check for hit/miss
                
                if (hit) {
                    System.out.println("Hit!");
                } else {
                    System.out.println("Miss.");
                    player1Turn = false; // End Player 1's turn on miss
                }

                // Check for game over conditions
                if (compPlayer.board.allShipsSunk()) {
                    System.out.println("Player 1 wins!");
                    gameOver = true;
                    break;
                }
            }

            // Check if the game is over before allowing the computer's turn
            if (!gameOver) {
                // Computer's turn
                System.out.println("Computer's turn:");
                int[] computerGuess = {0, 0}; // Replace with actual computer guessing logic
                boolean hit = player1Board.receiveGuess(computerGuess[0], computerGuess[1]);
                
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
        }
    }
}

