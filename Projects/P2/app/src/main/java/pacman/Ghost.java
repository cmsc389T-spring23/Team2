package pacman;

import java.util.ArrayList;
import java.util.HashSet;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    return null;
  }

  /*
   * Description: This function uses the get_valid_moves function to find the
   * possible locations that a ghost can move to from its current location and
   * chooses to move in one of those directions. You are free to apply an
   * algorithm here if you would like, but the only requirement is that you move
   * in a valid direction. To move successfully, make sure to call the map move
   * function and update the ghost's location. If the ghost is able to move, this
   * function returns true otherwise it returns false.
   */
  public boolean move() {
    ArrayList<Location> validMoves = get_valid_moves();
    if (validMoves.size() == 0) {
      return false;
    } else {
      HashSet<Location> bestMoves = new HashSet<Location>();
      for (Location location : validMoves) {
        Ghost ghost = new Ghost("", location, myMap);
        if (ghost.is_pacman_in_range() == true) {
          bestMoves.add(location);
        }
      }

      /* in the case of no optimal moves, just pick a random spot to move */
      if (bestMoves.size() == 0) {
        Random rando = new Random();
        int choice = rando.nextInt(validMoves.size());
        Location finalMove = validMoves.get(choice);
        myMap.move(myName, finalMove, Map.Type.GHOST);
      } else {
        Random rando = new Random();
        int choice = rando.nextInt(validMoves.size());
        Location finalMove = validMoves.get(choice);
        myMap.move(myName, finalMove, Map.Type.GHOST);
      }
      return true;
    }
  } // end of move()

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    if (is_pacman_in_range()) {
      return this.myMap.attack(this.myName);
    } else {
      return false;
    }
  }
}
