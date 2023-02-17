package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManInRange extends TestCase {

  public void testPacManInRange() throws FileNotFoundException {
    MainFrame frame = new MainFrame();
    //adding pacman and ghost
    Ghost ghost = frame.addGhost(new Location(1, 1), "Red", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(0, 1)); //Creates PacMan at location x, y

    Ghost ghost2 = frame.addGhost(new Location(0, 0), "Blue", Color.blue); //Creates a blue ghost named "Bule" at location x,y
    PacMan pacman2 = frame.addPacMan(new Location(2, 2)); //Creates PacMan at location x, y
    //should return false
    assertEquals(ghost.is_pacman_in_range(), true);
    //should return true
    assertEquals(ghost2.is_pacman_in_range(), false);
  }
}
