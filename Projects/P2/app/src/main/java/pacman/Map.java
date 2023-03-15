package pacman;

import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc))
      field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public HashMap<Location, HashSet<Type>> getField() {
    return field;
  }

  public HashMap<String, Location> getLocations() {
    return locations;
  }

  public boolean move(String name, Location loc, Type type) {
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location
    if (field.get(loc).contains(Type.WALL)) {
      return false;
    }
    // Get the comp and old location
    JComponent comp = components.get(name);
    Location oldLoc = locations.get(name);

    // Update locations, components, and the component's location
    locations.put(name, loc);
    comp.setLocation(loc.x, loc.y);

    // Update field
    field.get(oldLoc).remove(type);
    field.get(loc).add(type);
    return true;
  }

  // getLoc() returns a HashSet of the types at the given location.
  public HashSet<Type> getLoc(Location loc) {
    HashSet<Type> types = field.get(loc);
    return types;
  }

  public boolean attack(String Name) {
    Location loc = locations.get(Name);

    Location checLocation1 = loc.shift(0, 1);
    Location checLocation2 = loc.shift(0, -1);
    Location checLocation3 = loc.shift(1, 0);
    Location checLocation4 = loc.shift(-1, 0);
    if (field.get(checLocation1).contains(Type.PACMAN) || field.get(checLocation2).contains(Type.PACMAN)
        || field.get(checLocation3).contains(Type.PACMAN) || field.get(checLocation4).contains(Type.PACMAN)) {
      gameOver = true;
      return true;
    } else {
      gameOver = false;
      return false;
    }
  }

  public JComponent eatCookie(String name) {
    Location loc = locations.get(name);
    if (field.get(loc).contains(Type.COOKIE)) {
      String cookie_id = "tok_x" + loc.x + "_y" + loc.y;
      JComponent cookie_comp = components.get(cookie_id);
      locations.remove(cookie_id);
      components.remove(cookie_id);
      field.get(loc).remove(Type.COOKIE);
      cookies++;
      return cookie_comp;
    } else {
      return null;
    }
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
  }
}
