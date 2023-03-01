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
    
    //Try a pacman at the bottom right of the map
    PacMan pacman2 = frame.addPacMan(new Location(23, 24));
    ArrayList<Location> answer2 = new ArrayList<Location>();
    assertEquals(pacman2.get_valid_moves(), answer2);
    // As expected, it can go no where. Down and right are out of bounds, up and left are walls.
    
    //Last try: try where pacman can move more than 1 direction
    PacMan pacman3 = frame.addPacMan(new Location(1, 3));
    ArrayList<Location> answer3 = new ArrayList<Location>();
    answer3.add(new Location(1,4));
    answer3.add(new Location(1,2));
    answer3.add(new Location(2,3));
    assertEquals(pacman3.get_valid_moves(), answer3);
  }
}
