# Amr Ibrahim UCID #30219524
# Ethan Stirling UCID #30229189

A simple console-based implementation of the classic Battleship game. Players take turns guessing the location of their opponent's ships, with the goal of sinking all the ships before their own are sunk.

## Features

- Two-player gameplay: One human player and one computer player.
- Ships are placed randomly on the computer's board.
- Players take turns making guesses.
- Players receive feedback on hits and misses.
- The game continues until one player sinks all the opponent's ships.

## Code Structure
**BattleshipGame**: The main class that initializes the game, manages player turns, and checks for win conditions.
  
- **Board**: Represents the game board where ships are placed and where guesses are received. Handles logic for placing ships, receiving guesses, and checking if all ships are sunk.

- **ComputerPlayer**: Represents the computer-controlled player that automatically places ships and makes guesses against the human player.

- **ConfigFileReader**: Responsible for reading the configuration file that defines the game board and ships for the computer player.

- **Coordinate**: Represents the coordinates (x, y) on the game board for placing ships and making guesses.

- **HumanPlayer**: Represents the human player who manually places ships and makes guesses.

- **Player**: A base class for both human and computer players that defines common attributes and methods.

#### Ships Subdirectory
- **BattleshipType**: Defines types of battleships, including their properties and behaviors.

- **PatrolBoat**: Represents a specific type of ship with its unique characteristics.

- **Ship**: Base class for all ships in the game, defining common properties and methods.

- **ShipFactory**: Responsible for creating instances of ships based on the configuration file.
