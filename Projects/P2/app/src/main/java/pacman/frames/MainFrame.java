package pacman;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Main Frame for Pac Man Game
 *
 * @author nandhinikrishnan
 */
public class MainFrame extends JFrame implements ActionListener {

  private PacMan pacman;
  private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
  private Color[] colors = {Color.red, Color.cyan, Color.pink, Color.orange};
  private String[] names = {"Blinky", "Inky", "Pinky", "Clyde"};
  private JLabel scoreboard;
  private JButton close;
  private Map myMap;
  public int scale = 20;
  public int dim = 30;
  private int score = 0;

  private boolean continueGame = true;

  public MainFrame() throws FileNotFoundException {

    super.setBackground(Color.BLACK);

    getContentPane().setBackground(Color.BLACK);

    scoreboard = new JLabel("Score: " + score);
    scoreboard.setBounds(100, 500, 400, 50);
    scoreboard.setForeground(Color.YELLOW);
    scoreboard.setFont(scoreboard.getFont().deriveFont(32.0f));
    add(scoreboard);

    close = new JButton("End Game");
    close.addActionListener(new CloseListener());
    close.setBounds(250, 500, 100, 50);
    add(close);

    setBounds(100, 100, scale * dim, scale * dim + 25);
    setLayout(null);

    myMap = new Map(dim);

    File text = new File("src/main/resources/Map.txt");
    Scanner scnr = new Scanner(text);
    int row = 0;
    while (scnr.hasNextLine()) {
      String line = scnr.nextLine();
      for (int col = 0; col < line.length(); col++) {
        Location loc = new Location(row, col);

        if (line.charAt(col) == '0') {
          WallComponent wall = new WallComponent(loc.x, loc.y, scale);
          myMap.add("wall", loc, wall, Map.Type.WALL);
          add(wall);
          wall.setLocation(row, col);
        } else if (line.charAt(col) == '1') {
          CookieComponent tok = new CookieComponent(loc.x, loc.y, scale);
          myMap.add("tok_x" + row + "_y" + col, loc, tok, Map.Type.COOKIE);
          add(tok);
          tok.setLocation(row, col);
        }
      }
      row++;
    }

    scnr.close();
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public PacMan addPacMan(Location loc) {
    pacman = new PacMan("pacman", loc, myMap);
    PacManComponent pc = new PacManComponent(loc.x, loc.y, scale);
    myMap.add("pacman", loc, pc, Map.Type.PACMAN);
    add(pc);
    return pacman;
  }

  public Ghost addGhost(Location loc, String name, Color color) {
    Ghost ghost = new Ghost(name, loc, myMap);
    GhostComponent comp = new GhostComponent(loc.x, loc.y, color, scale);
    myMap.add(name, loc, comp, Map.Type.GHOST);
    add(comp);
    ghosts.add(ghost);
    return ghost;
  }

  public void initPlayers() {
    addPacMan(new Location(1, 1));

    int i = 0;
    for (Color color : colors) {
      int x = (int) (Math.random() * 2 + dim / 2);
      int y = (int) (Math.random() * 2 + dim / 2);
      Location loc = new Location(x, y);
      addGhost(loc, names[i++], color);
    }
  }

  public Map getMap() {
    return myMap;
  }

  public void startGame() {
    Timer timer =
        new Timer(
            100,
            new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e) {
                if (continueGame) {
                  pacman.move();
                  JComponent temp = pacman.consume();
                  if (temp != null) remove(temp);

                  for (Ghost ghost : ghosts) {
                    ghost.move();
                    ghost.attack();
                  }
                }

                score = myMap.getCookies();
                scoreboard.setText("Score " + score);
                if (myMap.isGameOver()) {
                  continueGame = false;
                  score = myMap.getCookies();
                  JOptionPane.showMessageDialog(
                      null,
                      "Game Over! \n Final Score: " + score,
                      "GAME OVER",
                      JOptionPane.INFORMATION_MESSAGE);
                  System.exit(0);
                }
                repaint();
              }
            });
    timer.start();
  }

  public static void main(String[] args) throws FileNotFoundException {
    MainFrame myFrame = new MainFrame();
    myFrame.initPlayers();
    myFrame.startGame();
    myFrame.getContentPane().setBackground(Color.BLACK);
    myFrame.setTitle("PACMAN");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint(); // calls the paint component method draws and repaint redraws
  }

  private class CloseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      continueGame = false;
      score = myMap.getCookies();
      JOptionPane.showMessageDialog(
          null,
          "Thanks For Playing! \n Final Score: " + score,
          "GAME OVER",
          JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
  }
}
