# Project 1: PacMan, by Team 2

## Team members
Michael Tang, Wyatt Scott, Jason Devers, Tyler Pettway

## An image of the code playing pacman
## Section on how to run the code from the command line
## Code block for command to compile and run the game
## Functions:
Ghost - attack()
This method allows the ghost to attack pacman if it's in range. It starts by calling the is_pacman_in_range method and if it returns true, the method returns a call to Map's attack method, which itself will return true if the attack was successful. Otherwise, the method returns false.

The test function creates pacman at location (1,1) and a ghost at location (1,2). Since the ghost is right next to pacman, the method should return true.

ghost - get_valid_moves()
Returns an ArrayList of locations that a ghost can legally move to.
This function creates 4 different possible locations the ghost can move, (the four cardinal directions), and checks if the locations on the map are walls or out of bounds. If the location is a wall or out of bounds, the location is not added to the resulting arrayList, otherwise, it is.

The test creates different ghosts and verifies that they cannot move out of bounds, or through walls, but can go through other ghosts and pacman. The first test verifies the ghost can move multiple directions, through pacman, and cannot go through walls.
The second test verifies the ghost cannot go out of bounds.
The last test verifies the ghost can go through other ghosts.

ghost - is_pacman_in_range()
Returns a boolean variable result.
This function creates 4 different possible locations the ghost can move, (the four cardinal directions), and checks if the locations contain a Pacman. If so this means a pacman is in range and thus the result variable is set to true. If not the result variable is left as false and is returned.

To test this I created a test where one set of conditions would return true and the other would return false. Both pass but getLoc was required to test this. 

### `ghost - move() -> boolean`
- Implementation: This function uses the get_valid_moves function to find the possible locations that a ghost can move to from its current location and chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. To move successfully, make sure to call the map move function and update the ghost's location. If the ghost is able to move, this function returns true otherwise it returns false.
- Testing: We test if it moves to valid and invalid locations, returning true if it was valid, returning false if it wasn't.

