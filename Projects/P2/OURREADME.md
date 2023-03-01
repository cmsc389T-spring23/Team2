# Project 1: PacMan, by Team 2

## Team members
Michael Tang, Wyatt Scott, Jason Devers, Tyler Pettway

## An image of the code playing pacman
## Section on how to run the code from the command line
## Code block for command to compile and run the game
## Functions

### `Map-eatCookie(String name) -> JComponent`
 - Implementation: The goal of this method is to update the map by having the pacman eat a cookie if it's able to. The method starts by determining the location of the pacman by using pacman's name provided in the method's name parameter. If pacman's location overlaps with an available cookie, the method will retrieve the cookie's id and remove the cookie from the following variables: locations, components, and field. Afterwards,  the cookie counter is incremented and the JComponent associated with the cookie id is returned. However, if pacman's location doesn't overlap with a cookie, the method returns null and the variables remain the same.

 - Testing: The test function creates a pacman and puts it in location (1,1), which overlaps with a cookie. After the eatCookie method is called, the test checks to see if the cookie counter increased. In this case, the cookie counter should be equal to 1. 



### `Pacman-get_valid_moves() -> ArrayList`
 - Implementation: Returns an ArrayList of locations that pacman can legally move to.
This function creates 4 different possible locations pacman can move, (the four cardinal directions), and checks if the locations on the map are walls or out of bounds. If the location is a wall or out of bounds, the location is not added to the resulting arrayList, otherwise, it is.

 - Testing: The test for this method creates 3 pacmen in 3 different positions, and tests that the method returns the correct valid moves. 
The first test verifies that moves out of bounds on the top are invalid, moves into walls are valid, and moves into ghosts are valid. 
The second test tests that moves out of bounds on the right and bottom are invalid and moves into walls are invalid.
The last test verifies that the function returns the correct possible moves when there are multiple valid moves.

### `Map-attack() -> Boolean`
 - Implementation: Returns true if the attack was successful and false if not.
This function creates 4 different possible locations that the named ghost can attack, (the four cardinal directions), and checks if the locations contain a pacman. If so the gameOver variable is updated to true and true is returned. If not the gameOver variable is set to its default value of false and false is returned.

 - Testing: When it comes to testing I created a test where true would be returned and one where false would be returned based on the conditions set up by the test. Both passed.

### `Map-move() -> Boolean`
- Implementation: This function checks if the new location is wall, and if it is, whatever was passed into to method (a ghost or pacman,) cannot move there,
so the method returns false.
Else, the ghost or pacman can move there, so I get the old location, and a reference to the JComonent of the ghost/pacman we want.
Then I update the location in the locations HashMap, update the JComponent's location, and finally delete the type from the old location and field,
and add the type to the new location in field.

 - Testing: The test for this spawns a pacman at 1,1 and moves it to the right where it can be moved since 1,2 is an empty space.
Then it checks that the old location in field does not contain a Type.PACMAN, the new location does, and that pacman's location in the locations HashMap is set correctly.
Finally it checks that a ghost at 1,1 cannot move to 0,1 as 0,1 is a wall.


### `Map-getLoc() -> HashSet`

- Implementation: `getLoc()` returns a HashSet of the types at the given location. If the location is on the edge of the map, return a HashSet containing only Type.WALL. If the location is not on the edge of the map, return a HashSet containing only Type.EMPTY. If the location is not on the edge of the map and contains a cookie, return a HashSet containing Type.EMPTY and Type.COOKIE.
- Testing: Given 4 different locations, we test if the location is able to determine what the location is. We also test it with `WALL` types. 

### `Ghost-attack() -> Boolean`
 - Implementation: This method allows the ghost to attack pacman if it's in range. It starts by calling the is_pacman_in_range method and if it returns true, the method returns a call to Map's attack method, which itself will return true if the attack was successful. Otherwise, the method returns false.

 - Testing: The test function creates pacman at location (1,1) and a ghost at location (1,2). Since the ghost is right next to pacman, the method should return true.

### `Ghost-get_valid_moves() -> ArrayList`
 - Implementation: Returns an ArrayList of locations that a ghost can legally move to.
This function creates 4 different possible locations the ghost can move, (the four cardinal directions), and checks if the locations on the map are walls or out of bounds. If the location is a wall or out of bounds, the location is not added to the resulting arrayList, otherwise, it is.

 - Testing: The test creates different ghosts and verifies that they cannot move out of bounds, or through walls, but can go through other ghosts and pacman. The first test verifies the ghost can move multiple directions, through pacman, and cannot go through walls.
The second test verifies the ghost cannot go out of bounds.
The last test verifies the ghost can go through other ghosts.

### `Ghost-is_pacman_in_range() -> Boolean`
 - Implementation: Returns a boolean variable result.
This function creates 4 different possible locations the ghost can move, (the four cardinal directions), and checks if the locations contain a Pacman. If so this means a pacman is in range and thus the result variable is set to true. If not the result variable is left as false and is returned.

 - Testing: To test this I created a test where one set of conditions would return true and the other would return false. Both pass but getLoc was required to test this. 

### `Ghost-move() -> Boolean`
- Implementation: This function uses the get_valid_moves function to find the possible locations that a ghost can move to from its current location and chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. To move successfully, make sure to call the map move function and update the ghost's location. If the ghost is able to move, this function returns true otherwise it returns false.
- Testing: We test if it moves to valid and invalid locations, returning true if it was valid, returning false if it wasn't.

