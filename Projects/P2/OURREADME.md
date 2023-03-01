# Project 1: PacMan, by Team 2

## Team members
Michael Tang, Wyatt Scott, Jason Devers, Tyler Pettway

## An image of the code playing pacman
## Section on how to run the code from the command line
## Code block for command to compile and run the game
## Functions:
Ghost - attack(): This method allows the ghost to attack pacman if it's in range. It starts by calling the is_pacman_in_range method and if it returns true, the method returns a call to Map's attack method, which itself will return true if the attack was successful. Otherwise, the method returns false.

The test function creates pacman at location (1,1) and a ghost at location (1,2). Since the ghost is right next to pacman, the method should return true.