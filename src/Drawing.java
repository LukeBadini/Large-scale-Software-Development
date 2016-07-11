import java.awt.*;
import java.util.ArrayList;

public class Drawing {
	
	private ArrayList<Shape> shapes;
	// Grid extra credit
	private ArrayList<Segment> grid;
	private Color currentColor;

	
	/**
	 * A constructor that creates an empty drawing
	 * 
	 * @param c the initial default color of the drawing
	 */
	public Drawing(Color c) {
		currentColor = c;
		shapes = new ArrayList<Shape>();
		grid = new ArrayList<Segment>();
		return;
	}
	
	/**
	 * Adds a shape to the drawing
	 * 
	 * @param s the shape to be added
	 */
	public void addShape(Shape s) {
		shapes.add(0, s);
		return;
	}
	
	/**
	 * Sets the currentColor of the Drawing
	 * 
	 * @param c new color
	 */
	public void setColor(Color c) {
		currentColor = c;
		return;
	}
	
	/**
	 * @return the current color of the drawing
	 */
	public Color getColor() {
		return currentColor;
	}
	
	/**
	 * Changes the color of the front-most shape under a point
	 * to the currentColor of the Drawing
	 * 
	 * @param p a given point
	 */
	public void changeColor(Point p) {
		Shape toChange = getFrontmostContainer(p);
		if (toChange != null) {
			toChange.setColor(currentColor);
		}
		return;
	}
	
	/**
	 * Draws all shapes in the drawing
	 * 
	 * @param graphic the graphics object to draw on
	 */
	public void draw(Graphics graphic) {
		// Grid extra credit
		if (!grid.isEmpty()) {
			for (Segment g : grid) {
				g.drawShape(graphic);
			}
		}
		
		if (!shapes.isEmpty()) {
			for (int i = (shapes.size() - 1); i >= 0; i--) {
				shapes.get(i).drawShape(graphic);
			}
		}
		return;
	}
	
	/**
	 * Returns the front-most shape under a point
	 * 
	 * @param p a given point
	 * @return the front-most Shape under Point p or null
	 *         if there are no Shapes under p
	 */
	public Shape getFrontmostContainer(Point p) {
		for (Shape s : shapes) {
			if (s.containsPoint(p)) {
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Removes the front-most shape under a point
	 * 
	 * @param p a given point
	 */
	public void deleteFrontmostShape(Point p) {
		Shape toRemove = getFrontmostContainer(p);
		shapes.remove(toRemove);
		return;
	}
	
	/**
	 * Move the front-most shape under a point to the
	 * front of the Drawing
	 * 
	 * @param p a given point
	 */
	public void moveToFront(Point p) {
		Shape toMove = getFrontmostContainer(p);
		shapes.remove(toMove);
		shapes.add(0, toMove);
		return;
	}
	
	/**
	 * Move the front-most shape under a point to the
	 * back of the Drawing
	 * 
	 * @param p a given point
	 */
	public void moveToBack(Point p) {
		Shape toMove = getFrontmostContainer(p);
		shapes.remove(toMove);
		shapes.add(toMove);
		return;
	}
	
	/**
	 * @return the grid ArrayList of the Drawing
	 */
	public ArrayList<Segment> getGrid() {
		return grid;
	}
	
	/**
	 * Sets the grid of a Drawing to a new ArrayList of segments
	 * 
	 * @param g the new ArrayList of segments
	 */
	public void setGrid(ArrayList<Segment> g) {
		grid = g;
		return;
	}
}
