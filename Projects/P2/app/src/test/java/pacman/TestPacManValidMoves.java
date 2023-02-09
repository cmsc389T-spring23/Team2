package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    //Creating A Map
    MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
    //NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(0, 1)); //Creates PacMan at location x, y
    
    //Check the correct moves are calculated
    ArrayList<Location> answer = new ArrayList<Location>();
    answer.add(new Location(1,1));
    assertEquals(pacman.get_valid_moves(), answer);
  }
}
