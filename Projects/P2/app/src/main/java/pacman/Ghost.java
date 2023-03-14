package pacman;

import java.util.ArrayList;
import java.util.HashSet;
import pacman.Map.Type;
import java.util.Random;
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
    // ArrayList<Location> result = new ArrayList<Location>();
    // Location possLocation1 = myLoc.shift(0,1);
    // Location possLocation2 = myLoc.shift(0,-1);
    // Location possLocation3 = myLoc.shift(1, 0);
    // Location possLocation4 = myLoc.shift(-1, 0);
    // if (isValidMove(possLocation1)) result.add(possLocation1);
    // if (isValidMove(possLocation2)) result.add(possLocation2);
    // if (isValidMove(possLocation3)) result.add(possLocation3);
    // if (isValidMove(possLocation4)) result.add(possLocation4);
    // return result;  
  }

  private boolean isValidMove(Location loc){
    if (loc.x < 0 || loc.x > 23 || loc.y < 0 || loc.y > 24|| myMap.getField().get(loc).contains(Type.WALL) ) {
      return false;
    } else {
      return true;
    }
  }

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
    boolean result = false;
    Location checLocation1 = myLoc.shift(0,1);
    Location checLocation2 = myLoc.shift(0,-1);
    Location checLocation3 = myLoc.shift(1, 0);
    Location checLocation4 = myLoc.shift(-1, 0);
    if (myMap.getLoc(checLocation1).contains(Map.Type.PACMAN) || myMap.getLoc(checLocation2).contains(Map.Type.PACMAN) || myMap.getLoc(checLocation3).contains(Map.Type.PACMAN) || myMap.getLoc(checLocation4).contains(Map.Type.PACMAN)){
      result = true;
    }

    return result;
  }

  public boolean attack() {
    if (is_pacman_in_range()) {
      return this.myMap.attack(this.myName);
    } else {
      return false;
    }
  }
}
