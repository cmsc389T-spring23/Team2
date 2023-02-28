package pacman;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComponent;
import pacman.Map.Type;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    return null;
  }

  public boolean move() {
    ArrayList<Location> validMoves = get_valid_moves();
    if (validMoves.size() == 0) {
      return false;
    } else {
      HashSet<Location> safeMoves = new HashSet<Location>();
      for (Location location : validMoves) {
        PacMan man = new PacMan("", location, myMap);
        if (man.is_ghost_in_range() == false) {
          safeMoves.add(location);
        }
      }

      if (safeMoves.size() == 0) {
        Random rando = new Random();
        int choice = rando.nextInt(validMoves.size());
        Location finalMove = validMoves.get(choice);
        myMap.move(myName, finalMove, Map.Type.GHOST);
      } else {
        Random rando = new Random();
        int choice = rando.nextInt(validMoves.size());
        Location finalMove = validMoves.get(choice);
        myMap.move(myName, finalMove, Map.Type.PACMAN);
      }

      return true;
    }

  }

  public boolean is_ghost_in_range() {
    boolean result = false;
    Location checLocation1 = myLoc.shift(0,1);
    Location checLocation2 = myLoc.shift(0,-1);
    Location checLocation3 = myLoc.shift(1, 0);
    Location checLocation4 = myLoc.shift(-1, 0);
    if (myMap.getLoc(checLocation1).contains(Map.Type.GHOST) || myMap.getLoc(checLocation2).contains(Map.Type.GHOST) || myMap.getLoc(checLocation3).contains(Map.Type.GHOST) || myMap.getLoc(checLocation4).contains(Map.Type.GHOST)){
      result = true;
    }

    return result;
  }

  public JComponent consume() {
    return null;
  }
}