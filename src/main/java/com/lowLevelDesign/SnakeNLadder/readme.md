Snake and ladder design

Classes

Game
Board
Piece
Player
Square
Dice
Snake
Ladder
Move

Game will have a Board
Game will have n players
Game will have a die
Game has a list of moves

Board will have n pieces (equal to number of players)
Board will have squares (always perfect squares of a number, resulting in a Square shaped board)

Dice will have 6 faces

Player will have a piece

Piece will have a color
Piece will have a square

Square will have a piece
Square might have a snake or a ladder

Move validation required

Move has a prev square
Move has a next square
Move has a piece


Move is valid if player is not currently on a snakes top 
AND
Move is valid if player is not currently on a ladder bottom
AND 
Move is valid if the next square is not out of bounds








