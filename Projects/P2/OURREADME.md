# Project 1: PacMan, by Team 2

## Team members
Michael Tang, Wyatt Scott, Jason Devers, Tyler Pettway

## An image of the code playing pacman
## Section on how to run the code from the command line
## Code block for command to compile and run the game
## Functions:
 Map - eatCookie(String name): The goal of this method is to update the map by having the pacman eat a cookie if it's able to. The method starts by determining the location of the pacman by using pacman's name provided in the method's name parameter. If pacman's location overlaps with an available cookie, the method will retrieve the cookie's id and remove the cookie from the following variables: locations, components, and field. Afterwards,  the cookie counter is incremented and the JComponent associated with the cookie id is returned. However, if pacman's location doesn't overlap with a cookie, the method returns null and the variables remain the same.

 The test function creates a pacman and puts it in location (1,1), which overlaps with a cookie. After the eatCookie method is called, the test checks to see if the cookie counter increased. In this case, the cookie counter should be equal to 1. 

 