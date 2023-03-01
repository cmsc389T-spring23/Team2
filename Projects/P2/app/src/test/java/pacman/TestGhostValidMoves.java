package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    //Creating A Map
     MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized

     //Creating Players
     Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
     PacMan pacman = frame.addPacMan(new Location(2, 1)); //Creates PacMan at location x, y

     //Check the correct moves are calculated
     //Ghost should be able to move down and right
     ArrayList<Location> answer = new ArrayList<Location>();
     answer.add(new Location(1,2));
     answer.add(new Location(2,1));
     assertEquals(ghost.get_valid_moves(), answer);

     //This ghost should not be able to move anywhere
     Ghost ghost1 = frame.addGhost(new Location(0, 0), "name", Color.red); //Creates a red ghost named "name" at location x,y
     Ghost ghost4 = frame.addGhost(new Location(0, 0), "name", Color.red); //Creates a red ghost named "name" at location x,y
     ArrayList<Location> answer1 = new ArrayList<Location>();
     assertEquals(ghost1.get_valid_moves(), answer1);
     assertEquals(ghost4.get_valid_moves(), answer1);

     Ghost ghost2 = frame.addGhost(new Location(22, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
     Ghost ghost3 = frame.addGhost(new Location(22, 2), "name", Color.red); //Creates a red ghost named "name" at location x,y
     ArrayList<Location> answer2 = new ArrayList<Location>();
     answer2.add(new Location(22,2));
     answer2.add(new Location(21,1));
     assertEquals(ghost2.get_valid_moves(), answer2);
  }
}
