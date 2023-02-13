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
    return false;
  }

  public boolean is_ghost_in_range() {
    Location checLocation1 = myLoc.shift(0,1);
    Location checLocation2 = myLoc.shift(0,-1);
    Location checLocation3 = myLoc.shift(1, 0);
    Location checLocation4 = myLoc.shift(-1, 0);
    if (getLoc(possLocation1).contains(GHOST)||getLoc(possLocation2).contains(GHOST) || getLoc(possLocation3).contains(GHOST) || getLoc(possLocation4).contains(GHOST)){
      return true;
    }
    return false;
  }

  public JComponent consume() {
    return null;
  }
}