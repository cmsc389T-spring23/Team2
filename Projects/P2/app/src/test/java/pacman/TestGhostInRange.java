package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
    MainFrame frame = new MainFrame();
    //adding pacman and ghost
    Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(0, 1)); //Creates PacMan at location x, y

    Ghost ghost2 = frame.addGhost(new Location(0, 0), "name", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman2 = frame.addPacMan(new Location(2, 2)); //Creates PacMan at location x, y
    //should return false
    assertEquals(pacman2.is_ghost_in_range(), false);
    //should return true
    assertEquals(pacman.is_ghost_in_range(), true);
  }
}
