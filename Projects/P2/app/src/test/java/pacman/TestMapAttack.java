package pacman;
import junit.framework.*;
import java.io.*;
import java.awt.Color;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    MainFrame frame = new MainFrame();
    MainFrame frame2 = new MainFrame();
    //adding pacman and ghost
    Ghost ghost = frame.addGhost(new Location(9, 11), "Red", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(9, 12)); //Creates PacMan at location x, y

    Ghost ghost2 = frame2.addGhost(new Location(8, 5), "Blue", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman2 = frame2.addPacMan(new Location(8, 7)); //Creates PacMan at location x, y
    //should return false
    assertEquals(frame.getMap().attack("Red"), true);
    //should return true
    assertEquals(frame2.getMap().attack("Blue"), false);

    return;
  }
}
