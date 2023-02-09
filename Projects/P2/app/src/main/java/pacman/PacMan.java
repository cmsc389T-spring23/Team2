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
    ArrayList<Location> result = new ArrayList<Location>();
    Location possLocation1 = myLoc.shift(0,1);
    Location possLocation2 = myLoc.shift(0,-1);
    Location possLocation3 = myLoc.shift(1, 0);
    Location possLocation4 = myLoc.shift(-1, 0);
    if (isValidMove(possLocation1)) result.add(possLocation1);
    if (isValidMove(possLocation2)) result.add(possLocation2);
    if (isValidMove(possLocation3)) result.add(possLocation3);
    if (isValidMove(possLocation4)) result.add(possLocation4);

    return result;
  }

  private boolean isValidMove(Location loc){
    if (loc.x < 0 || loc.x > myMap.getDim() || loc.y < 0 || loc.y > myMap.getDim() || myMap.getfield().get(loc).contains(Type.WALL) ) {
      return false;
    } else {
      return true;
    }
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
