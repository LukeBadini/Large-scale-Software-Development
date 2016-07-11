/**
 * Editor.java
 * An applet for an object-oriented graphical editor.
 * This class implements the GUI for the editor.
 * 
 * This is a provided file with parts to be filled in.
 *
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Editor extends JApplet {
  private static final long serialVersionUID = 1L;
  
  private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 500;
  private final Color initialColor = Color.red; // default color starts as red

  private Command cmd; // the command being executed
  private Drawing dwg; // the drawing: shapes in order
  private ColorIndicator colorBox; // a GUI component to show the current default color

  /**
   * Set up the buttons and canvas and register the listeners.
   */
  public void init() {
    cmd = new Command(); // all methods in Command are empty
    dwg = new Drawing(initialColor); // make an empty drawing

    // The drawing will appear in a white CanvasPanel.
    CanvasPanel canvasPanel = new CanvasPanel();
    canvasPanel.setBackground(Color.white);

    // Make JButton objects for all the command buttons.
    JButton rectButton = new JButton("Rectangle");
    JButton ellipseButton = new JButton("Ellipse");
    JButton lineButton = new JButton("Line");  
    JButton moveButton = new JButton("Move");
    JButton deleteButton = new JButton("Delete");
    JButton frontButton = new JButton("Front");
    JButton backButton = new JButton("Back");
    JButton exchangeButton = new JButton("Exchange");   
    // Grid extra credit
    JButton gridButton = new JButton("Grid");
    //
    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    // Add listeners for all the command buttons.
    rectButton.addActionListener(new RectButtonListener());
    ellipseButton.addActionListener(new EllipseButtonListener());
    lineButton.addActionListener(new LineButtonListener());    
    moveButton.addActionListener(new MoveButtonListener());
    deleteButton.addActionListener(new DeleteButtonListener());
    frontButton.addActionListener(new FrontButtonListener());
    backButton.addActionListener(new BackButtonListener());
    exchangeButton.addActionListener(new ExchangeButtonListener()); 
    // Grid extra credit
    gridButton.addActionListener(new GridButtonListener());
    //
    redButton.addActionListener(new RedButtonListener());
    greenButton.addActionListener(new GreenButtonListener());
    blueButton.addActionListener(new BlueButtonListener());

    // The command buttons will be arranged in 3 rows.  Each row will
    // appear in its own JPanel, and the 3 JPanels will be stacked
    // vertically.
    JPanel shapePanel = new JPanel(); // holds buttons for adding shapes
    JLabel shapeLabel = new JLabel("Add shape:");
    shapePanel.setLayout(new FlowLayout());
    shapePanel.add(shapeLabel);
    rectButton.setBackground(Color.yellow);
    ellipseButton.setBackground(Color.yellow);
    lineButton.setBackground(Color.yellow);    
    shapePanel.add(rectButton);
    shapePanel.add(ellipseButton);
    shapePanel.add(lineButton);

    JPanel editPanel = new JPanel(); // holds buttons for editing operations
    JLabel editLabel = new JLabel("Edit:");
    editPanel.setLayout(new FlowLayout());
    editPanel.add(editLabel);
    moveButton.setBackground(Color.yellow);
    deleteButton.setBackground(Color.yellow);
    frontButton.setBackground(Color.yellow);
    backButton.setBackground(Color.yellow);
    exchangeButton.setBackground(Color.yellow);
    // Grid extra credit
    gridButton.setBackground(Color.yellow);
    //    
    editPanel.add(moveButton);
    editPanel.add(deleteButton);
    editPanel.add(frontButton);
    editPanel.add(backButton);
    editPanel.add(exchangeButton);
    editPanel.add(gridButton);
    

    // The color panel is slightly different from the other two. In
    // addition to a label and buttons for the color commands, this
    // panel holds a ColorIndicator that gives the current default
    // color.
    JPanel colorPanel = new JPanel();
    JLabel colorLabel = new JLabel("Colors:");
    colorPanel.setLayout(new FlowLayout());
    colorPanel.add(colorLabel);
    colorBox = new ColorIndicator();
    colorBox.show(initialColor);
    redButton.setBackground(Color.yellow);
    greenButton.setBackground(Color.yellow);
    blueButton.setBackground(Color.yellow);
    colorPanel.add(colorBox);
    colorPanel.add(redButton);
    colorPanel.add(greenButton);
    colorPanel.add(blueButton);

    // Use a grid layout to stack the button panels vertically.  Also,
    // give them a cyan background.
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(3, 1));
    shapePanel.setBackground(Color.cyan);
    editPanel.setBackground(Color.cyan);
    colorPanel.setBackground(Color.cyan);
    buttonPanel.add(shapePanel);
    buttonPanel.add(editPanel);
    buttonPanel.add(colorPanel);

    // Now we have two panels: buttonPanel and canvasPanel.  We want
    // buttonPanel to appear above canvasPanel, and canvasPanel should
    // grow with the applet.
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(buttonPanel, BorderLayout.NORTH);
    cp.add(canvasPanel, BorderLayout.CENTER);

    setSize(APPLET_WIDTH, APPLET_HEIGHT);
  }

  /**
   * What to do when rectButton is pressed.
   */
  private class RectButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new RectCmd();
      repaint();
    }
  }

  /**
   * What to do when ellipseButton is pressed.
   */
  private class EllipseButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new EllipseCmd();
      repaint();
    }
  }

  /**
   * What to do when lineButton is pressed.
   */
  private class LineButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new SegmentCmd();
      repaint();
    }
  }

  /**
   * What to do when moveButton is pressed.
   */
  private class MoveButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new MoveCmd();
      repaint();
    }
  }

  /**
   * What to do when deleteButton is pressed.
   */
  private class DeleteButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new DeleteCmd();
      repaint();
    }
  }

  /**
   * What to do when frontButton is pressed.
   */
  private class FrontButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new FrontCmd();
      repaint();
    }
  }

  /**
   * What to do when backButton is pressed.
   */
  private class BackButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new BackCmd();
      repaint();
    }
  }

  /**
   * What to do when exchangeButton is pressed.
   */
  private class ExchangeButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ExchangeCmd();
      repaint();
    }
  }
  
  /**
   * What to do when the gridButton is pressed
   *
   */
  // Grid extra credit
  private class GridButtonListener implements ActionListener {
	  public void actionPerformed(ActionEvent event) {
		  ArrayList<Segment> grid = dwg.getGrid();
		  if (grid.isEmpty()) {
			  fillGrid(grid);
		  }
		  else {
			  dwg.setGrid(new ArrayList<Segment>());
		  }
		  repaint();
	  }
  }
  
  /**
   * Fills the grid for a drawing
   * 
   * @param g the grid
   */
  private void fillGrid(ArrayList<Segment> g) {
	  drawHorizontal(g);
	  drawVertical(g);
  }
  
  /**
   * Draws the horizontal lines for a grid
   * @param g a grid
   */
  private void drawHorizontal(ArrayList<Segment> g) {
	  g.add(new Segment(Color.black, 0, 50, 2000, 50));
	  g.add(new Segment(Color.black, 0, 100, 2000, 100));
	  g.add(new Segment(Color.black, 0, 150, 2000, 150));
	  g.add(new Segment(Color.black, 0, 200, 2000, 200));
	  g.add(new Segment(Color.black, 0, 250, 2000, 250));
	  g.add(new Segment(Color.black, 0, 300, 2000, 300));
	  g.add(new Segment(Color.black, 0, 350, 2000, 350));
	  g.add(new Segment(Color.black, 0, 400, 2000, 400));
	  g.add(new Segment(Color.black, 0, 450, 2000, 450));
	  g.add(new Segment(Color.black, 0, 500, 2000, 500));
	  g.add(new Segment(Color.black, 0, 550, 2000, 550));
	  g.add(new Segment(Color.black, 0, 600, 2000, 600));
	  g.add(new Segment(Color.black, 0, 650, 2000, 650));
	  g.add(new Segment(Color.black, 0, 700, 2000, 700));
	  g.add(new Segment(Color.black, 0, 750, 2000, 750));
	  g.add(new Segment(Color.black, 0, 800, 2000, 800));
	  g.add(new Segment(Color.black, 0, 850, 2000, 850));
	  g.add(new Segment(Color.black, 0, 900, 2000, 900));
	  g.add(new Segment(Color.black, 0, 950, 2000, 950));
	  g.add(new Segment(Color.black, 0, 1000, 2000, 1000));
	  g.add(new Segment(Color.black, 0, 1050, 2000, 1050));
	  g.add(new Segment(Color.black, 0, 1100, 2000, 1100));
  }
  
  /**
   * Draws the vertival lines for a grid
   * @param g a grid
   */
  private void drawVertical(ArrayList<Segment> g) {
	  g.add(new Segment(Color.black, 50, 0, 50, 1100));
	  g.add(new Segment(Color.black, 100, 0, 100, 1100));
	  g.add(new Segment(Color.black, 150, 0, 150, 1100));
	  g.add(new Segment(Color.black, 200, 0, 200, 1100));
	  g.add(new Segment(Color.black, 250, 0, 250, 1100));
	  g.add(new Segment(Color.black, 300, 0, 300, 1100));
	  g.add(new Segment(Color.black, 350, 0, 350, 1100));
	  g.add(new Segment(Color.black, 400, 0, 400, 1100));
	  g.add(new Segment(Color.black, 450, 0, 450, 1100));
	  g.add(new Segment(Color.black, 500, 0, 500, 1100));
	  g.add(new Segment(Color.black, 550, 0, 550, 1100));
	  g.add(new Segment(Color.black, 600, 0, 600, 1100));
	  g.add(new Segment(Color.black, 650, 0, 650, 1100));
	  g.add(new Segment(Color.black, 600, 0, 600, 1100));
	  g.add(new Segment(Color.black, 650, 0, 650, 1100));
	  g.add(new Segment(Color.black, 700, 0, 700, 1100));
	  g.add(new Segment(Color.black, 750, 0, 750, 1100));
	  g.add(new Segment(Color.black, 800, 0, 800, 1100));
	  g.add(new Segment(Color.black, 850, 0, 850, 1100));
	  g.add(new Segment(Color.black, 900, 0, 900, 1100));
	  g.add(new Segment(Color.black, 950, 0, 950, 1100));
	  g.add(new Segment(Color.black, 1000, 0, 1000, 1100));
	  g.add(new Segment(Color.black, 1050, 0, 1050, 1100));
	  g.add(new Segment(Color.black, 1100, 0, 1100, 1100));
	  g.add(new Segment(Color.black, 1150, 0, 1150, 1100));
	  g.add(new Segment(Color.black, 1200, 0, 1200, 1100));
	  g.add(new Segment(Color.black, 1250, 0, 1250, 1100));
	  g.add(new Segment(Color.black, 1300, 0, 1300, 1100));
	  g.add(new Segment(Color.black, 1350, 0, 1350, 1100));
	  g.add(new Segment(Color.black, 1400, 0, 1400, 1100));
	  g.add(new Segment(Color.black, 1450, 0, 1450, 1100));
	  g.add(new Segment(Color.black, 1500, 0, 1500, 1100));
	  g.add(new Segment(Color.black, 1550, 0, 1550, 1100));
	  g.add(new Segment(Color.black, 1600, 0, 1600, 1100));
	  g.add(new Segment(Color.black, 1650, 0, 1650, 1100));
	  g.add(new Segment(Color.black, 1700, 0, 1700, 1100));
	  g.add(new Segment(Color.black, 1750, 0, 1750, 1100));
	  g.add(new Segment(Color.black, 1800, 0, 1800, 1100));
	  g.add(new Segment(Color.black, 1850, 0, 1850, 1100));
	  g.add(new Segment(Color.black, 1900, 0, 1900, 1100));
  }

  /**
   * What to do when redButton is pressed.
   */
  private class RedButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new RedCmd();
      dwg.setColor(initialColor);
      colorBox.show(initialColor);
      repaint();
    }
  }

  /**
   * What to do when greenButton is pressed.
   */
  private class GreenButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new GreenCmd();
      dwg.setColor(Color.green);
      colorBox.show(Color.green);
      repaint();
    }
  }

  /**
   * What to do when blueButton is pressed.
   */
  private class BlueButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new BlueCmd();
      dwg.setColor(Color.blue);
      colorBox.show(Color.blue);
      repaint();
    }
  }

  /**
   * A ColorIndicator shows what the current color is.
   */
  private class ColorIndicator extends JPanel {
    private static final long serialVersionUID = 0;
    
    private final int COLORBOX_WIDTH = 20, COLORBOX_HEIGHT = 20;

    /**
     * Constructor sets the size and border.
     */
    public ColorIndicator() {
      setBorder(BorderFactory.createEtchedBorder());
      setPreferredSize(new Dimension(COLORBOX_WIDTH, COLORBOX_HEIGHT));
    }

    /**
     * Show a new color.
     * @param color the color to show
     */
    public void show(Color color) {
      setBackground(color);
    }
  }

  /** 
   * CanvasPanel is the class upon which we actually draw.  It listens
   * for mouse events and calls the appropriate method of the current
   * command.
   */ 
  private class CanvasPanel extends JPanel implements MouseListener,
      MouseMotionListener {
    private static final long serialVersionUID = 0;
    
    /**
     * Constructor just needs to set up the CanvasPanel as a listener.
     */
    public CanvasPanel() {
      addMouseListener(this);
      addMouseMotionListener(this);
    }

    /**
     * Paint the whole drawing
     * @page the Graphics object to draw on
     */
    public void paintComponent(Graphics page) {
      super.paintComponent(page); // execute the paint method of JPanel
      dwg.draw(page); // have the drawing draw itself
    }

    /**
     * When the mouse is clicked, call the executeClick method of the
     * current command.
     */
    public void mouseClicked(MouseEvent event) {
      cmd.executeClick(event.getPoint(), dwg);
      repaint();
    }

    /**
     * When the mouse is pressed, call the executePress method of the
     * current command.
     */
    public void mousePressed(MouseEvent event) {
      cmd.executePress(event.getPoint(), dwg);
      repaint();
    }

    /** 
     * When the mouse is dragged, call the executeDrag method of the
     * current command.
     */
    public void mouseDragged(MouseEvent event) {
      cmd.executeDrag(event.getPoint(), dwg);
      repaint();
    }

    
    // We don't care about the other mouse events.
    public void mouseReleased(MouseEvent event) { }
    public void mouseEntered(MouseEvent event) { }
    public void mouseExited(MouseEvent event) { }
    public void mouseMoved(MouseEvent event) { }
  }
}
