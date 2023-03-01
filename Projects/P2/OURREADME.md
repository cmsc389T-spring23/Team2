# Project 1: PacMan, by Team 2

## Team members
Michael Tang, Wyatt Scott, Jason Devers, Tyler Pettway

## An image of the code playing pacman
## Section on how to run the code from the command line
## Code block for command to compile and run the game
## Functions:
Map - eatCookie(String name)
The goal of this method is to update the map by having the pacman eat a cookie if it's able to. The method starts by determining the location of the pacman by using pacman's name provided in the method's name parameter. If pacman's location overlaps with an available cookie, the method will retrieve the cookie's id and remove the cookie from the following variables: locations, components, and field. Afterwards,  the cookie counter is incremented and the JComponent associated with the cookie id is returned. However, if pacman's location doesn't overlap with a cookie, the method returns null and the variables remain the same.

The test function creates a pacman and puts it in location (1,1), which overlaps with a cookie. After the eatCookie method is called, the test checks to see if the cookie counter increased. In this case, the cookie counter should be equal to 1. 


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
map-move()
This function checks if the new location is wall, and if it is, whatever was passed into to method (a ghost or pacman,) cannot move there,
so the method returns false.
Else, the ghost or pacman can move there, so I get the old location, and a reference to the JComonent of the ghost/pacman we want.
Then I update the location in the locations HashMap, update the JComponent's location, and finally delete the type from the old location and field,
and add the type to the new location in field.

The test for this spawns a pacman at 1,1 and moves it to the right where it can be moved since 1,2 is an empty space.
Then it checks that the old location in field does not contain a Type.PACMAN, the new location does, and that pacman's location in the locations HashMap is set correctly.
Finally it checks that a ghost at 1,1 cannot move to 0,1 as 0,1 is a wall.

