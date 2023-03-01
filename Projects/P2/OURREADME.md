# Project 1: PacMan, by Team 2

## Team members
Michael Tang, Wyatt Scott, Jason Devers, Tyler Pettway

## An image of the code playing pacman
## Section on how to run the code from the command line
## Code block for command to compile and run the game
## Functions:
Pacman - consume(): This method has pacman eating a cookie if there's one in its location. If pacman overlaps with a cookie, the method will call eatCookie from the map class and return the JComponent of the eaten cookie. Otherwise, the method returns null without updating anything.

The test function puts pacman in location (1,1), where a cookie will be present. After consume() is called, the cookie counter should be increased to 1.

