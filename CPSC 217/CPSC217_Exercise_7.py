# Ethan Stirling #30229189
# Program: TicTacToe

def hasTicTacToe (board):
    # Check for a horizontal TicTacToe
    for row in board:
        if row[0] == row[1] == row[2] == "x":
            return True
    # Check for a vertical TicTacToe
    for col in range(3):
        if board[0][col] == board[1][col] == board[2][col] == "x":
            return True
    # Check for a diagonal TicTacToe
    for col in range (3):
        if board[0][0] == board[1][1] == board[2][2] == "x":
            return True

 # Prompt the user to enter three rows of characters
row1 = str(input("Enter values in row 1: ")).split()
row2 = str(input("Enter values in row 2: ")).split()
row3 = str(input("Enter values in row 3: ")).split()

# Create a two-dimensional list
board = [row1, row2, row3]

# Print out the two-dimensional list
print(f"Tic-tac-toe values are [{board}]")
# Check if there is a TicTacToe
if hasTicTacToe(board) is True:
    print("There is TicTacToe.")
else:
    print("There is no TicTacToe.")
# End of program