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

pacman- is_ghost_in_range()
Returns a boolean result variable.
This function creates 4 different possible locations a ghost can be around a given pacman, (the four cardinal directions), and checks if the locations the locations containn a ghost. If so the result variable is set to true and the returned, else it remains false and is returned as such.

To test this I created two senarios: one that would return true and one that would return false. Both passed but required getLoc to work.