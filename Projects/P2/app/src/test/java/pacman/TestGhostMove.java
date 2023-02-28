package pacman;

import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {

    Ghost ghost = frame.addGhost(new Location(1, 1), "inky", Color.red);
    ghost.setMoveStrategy(new MoveStrategy() {
      public int[] getMove(Ghost ghost, PacMan pacman, Maze maze) {
        return new int[] { 0, 0 };
      }
    });
    ghost.move();
    assertEquals(new Location(1, 1), ghost.getLocation());
  }
}
