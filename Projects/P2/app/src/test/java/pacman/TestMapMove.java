package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import pacman.Map.Type;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
    //Creating A Map
    MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y

    assertTrue(frame.getMap().move("pacman", new Location(1,2), Type.PACMAN));
    assertFalse(frame.getMap().getField().get(new Location(1,1)).contains(Type.PACMAN));
    assertTrue(frame.getMap().getField().get(new Location(1,2)).contains(Type.PACMAN));
    assertEquals(frame.getMap().getLocations().get("pacman"), new Location(1,2));

    assertFalse(frame.getMap().move("name", new Location(0,1), Type.GHOST));

  }
}
