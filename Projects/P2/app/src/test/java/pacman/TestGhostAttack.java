package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostAttack extends TestCase {

  public void testGhostAttack() throws FileNotFoundException {
    //Creating A Map
    MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
    //NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(1, 2), "name", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y
    assertEquals(ghost.attack(), true);
    return;
  }
}
