package pacman;

import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    Map map = new Map(5);
    Location loc = new Location(1, 1);
    map.add("pacman", loc, new JComponent() {
    }, Map.Type.PACMAN);
    assertEquals(loc, map.getLoc("pacman"));

    Map map2 = new Map(5);
    Location loc2 = new Location(1, 1);
    map2.add("pacman", loc2, new JComponent() {
    }, Map.Type.PACMAN);
    assertEquals(loc2, map2.getLoc("pacman"));

    Map map3 = new Map(5);
    Location loc3 = new Location(1, 1);
    map3.add("pacman", loc3, new JComponent() {
    }, Map.Type.PACMAN);
    assertEquals(loc3, map3.getLoc("pacman"));
  }
}
