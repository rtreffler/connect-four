# What is this?

Project I did as a part of [Hyperskill](https://hyperskill.org) course [Kotlin Basics](https://hyperskill.org/tracks/18).

It's the game of Connect Four, where two players play to get 4 disks in line, colum or diagonal.

It's refactored version for testing [State](https://en.wikipedia.org/wiki/State_pattern) pattern.

# How to run
When imported into IntelliJ IDEA it should just work. If not, Build -> Rebuild project.

# Comment
It's my first standalone project, I still don't know what I'm doing with the language and build system.

Any comments, pull requests, issue tickets appreciated. I'm particularly interested in build improvement and tests. 

# Game session
```text
Connect Four
First player's name:
John
Second player's name:
Doe
Set the board dimensions (Rows x Columns)
Press Enter for default (6 x 7)

Do you want to play single or multiple games?
For a single game, input 1 or press Enter
Input a number of games:

John VS Doe
6 X 7 board
Single game
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
John's turn:
1
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║o║ ║ ║ ║ ║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
Doe's turn:
5
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║o║ ║ ║ ║*║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
John's turn:
2
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║o║o║ ║ ║*║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
Doe's turn:
3
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║o║o║*║ ║*║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
John's turn:
2
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║o║ ║ ║ ║ ║ ║
║o║o║*║ ║*║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
Doe's turn:
4
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║o║ ║ ║ ║ ║ ║
║o║o║*║*║*║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
John's turn:
2
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║o║ ║ ║ ║ ║ ║
║ ║o║ ║ ║ ║ ║ ║
║o║o║*║*║*║ ║ ║
╚═╩═╩═╩═╩═╩═╩═╝
Doe's turn:
6
 1 2 3 4 5 6 7
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║ ║ ║ ║ ║ ║ ║
║ ║o║ ║ ║ ║ ║ ║
║ ║o║ ║ ║ ║ ║ ║
║o║o║*║*║*║*║ ║
╚═╩═╩═╩═╩═╩═╩═╝
Player Doe won
Game Over!
```