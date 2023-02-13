# Project 1: PacMan, by Team 2
title in progress?

# Team members:
Michael Tang

# Image of Code Playing Pacman

# A section on how to run the code from the command line
# Code block for command to compile and run the game

# Functions:

map-move()
This function checks if the new location is wall, and if it is, whatever was passed into to method (a ghost or pacman,) cannot move there,
so the method returns false.
Else, the ghost or pacman can move there, so I get the old location, and a reference to the JComonent of the ghost/pacman we want.
Then I update the location in the locations HashMap, update the JComponent's location, and finally delete the type from the old location and field,
and add the type to the new location in field.

The test for this spawns a pacman at 1,1 and moves it to the right where it can be moved since 1,2 is an empty space.
Then it checks that the old location in field does not contain a Type.PACMAN, the new location does, and that pacman's location in the locations HashMap is set correctly.
Finally it checks that a ghost at 1,1 cannot move to 0,1 as 0,1 is a wall.