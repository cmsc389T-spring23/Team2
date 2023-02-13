# Project 1: PacMan, by Team 2
title in progress?

# Team members:
Michael Tang

# Image of Code Playing Pacman

# A section on how to run the code from the command line
# Code block for command to compile and run the game

# Functions:

ghost - get_valid_moves()
Returns an ArrayList of locations that a ghost can legally move to.
This function creates 4 different possible locations the ghost can move, (the four cardinal directions), and checks if the locations on the map are walls or out of bounds. If the location is a wall or out of bounds, the location is not added to the resulting arrayList, otherwise, it is.

The test creates different ghosts and verifies that they cannot move out of bounds, or through walls, but can go through other ghosts and pacman. The first test verifies the ghost can move multiple directions, through pacman, and cannot go through walls.
The second test verifies the ghost cannot go out of bounds.
The last test verifies the ghost can go through other ghosts.