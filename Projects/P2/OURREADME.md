# Project 1: PacMan, by Team 2
title in progress?

# Team members:
Michael Tang, Wyatt Scott

# Image of Code Playing Pacman

# A section on how to run the code from the command line
# Code block for command to compile and run the game

# Functions:

pacman - get_valid_moves()
Returns an ArrayList of locations that pacman can legally move to.
This function creates 4 different possible locations pacman can move, (the four cardinal directions), and checks if the locations on the map are walls or out of bounds. If the location is a wall or out of bounds, the location is not added to the resulting arrayList, otherwise, it is.

The test for this method creates 3 pacmen in 3 different positions, and tests that the method returns the correct valid moves. 
The first test verifies that moves out of bounds on the top are invalid, moves into walls are valid, and moves into ghosts are valid. 
The second test tests that moves out of bounds on the right and bottom are invalid and moves into walls are invalid.
The last test verifies that the function returns the correct possible moves when there are multiple valid moves.

map-attack()
Returns true if the attack was successful and false if not.
This function creates 4 different possible locations that the named ghost can attack, (the four cardinal directions), and checks if the locations contain a pacman. If so the gameOver variable is updated to true and true is returned. If not the gameOver variable is set to its default value of false and false is returned.

When it comes to testing I created a test where true would be returned and one where false would be returned based on the conditions set up by the test. Both passed.


