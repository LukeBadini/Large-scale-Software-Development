import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 * @see Shape
 */
public class Segment extends Shape {
  private int firstX;
  private int firstY;
  private int secondX;
  private int secondY;
  private Color color;
  private final double TOLERANCE = 3;
  
  /**
   * Default constructor using the superclass constructor
   * 
   * @param c the color of the shape
   */
  public Segment(Color c, int x1, int y1, int x2, int y2) {
		super(c);
		color = c;
		firstX = x1;
		firstY = y1;
		secondX = x2;
		secondY = y2;
		return;
  }
  
  /**
   * Draws a segment on a given graphics object
   * 
   * @param page a given graphics object
   */
  public void drawShape(Graphics page) {
	  page.setColor(color);
	  page.drawLine(firstX, firstY, secondX, secondY);
	  return;
  }
  
  
  /**
   * Returns the center point of the segment
   */
  public Point getCenter() {
	  int centerX = (Math.max(firstX, secondX))/2;
	  int centerY = (Math.max(firstY, secondY))/2;
	  return new Point(centerX, centerY);
  }
  
  /**
   * Determines if a given point is within or close to the bounding
   * box of a segment
   * 
   * @return true if the point is within or close to the segment,
   *         false otherwise
   */
  public boolean containsPoint(Point p) {
	  return almostContainsPoint(p, firstX, firstY, secondX,
			  secondY, TOLERANCE);
  }
  
  /**
   * Moves a segment
   * 
   * @param deltaX how much to move the segment in the x direction
   * @param deltaY how much to move the segment in the y direction
   */
  public void move(int deltaX, int deltaY) {
	  firstX += deltaX;
	  firstY += deltaY;
	  secondX += deltaX;
	  secondY += deltaY;
	  return;
  }
  
  /**
   * Sets the x value for the first point in the Segment
   * 
   * @param x1 the new value for firstX
   */
  public void setX1(int x1) {
	  firstX = x1;
	  return;
  }
  
  /**
   * @return the x value for the first point in the Segment
   */
  public int getX1() {
	  return firstX;
  }
  
  /**
   * Sets the y value for the first point in the Segment
   * 
   * @param y1 the new value for firstY
   */
  public void setY1(int y1) {
	  firstY = y1;
	  return;
  }
  
  /**
   * @return the y value for the first point in the Segment
   */
  public int getY1() {
	  return firstY;
  }
  
  /**
   * Sets the x value for the second point in the Segment
   * 
   * @param x2 the new value for secondX
   */
  public void setX2(int x2) {
	  secondX = x2;
	  return;
  }
  
  /**
   * @return the x value for the second point in the Segment
   */
  public int getX2() {
	  return secondX;
  }
  
  /**
   * Sets the y value for the second point in the Segment
   * 
   * @param y2 the new value for secondY
   */
  public void setY2(int y2) {
	  secondY = y2;
	  return;
  }
  
  /**
   * @return the y value for the second point in the Segment
   */
  public int getY2() {
	  return secondY;
  }

  // Helper method that returns true if Point p is within a tolerance of a
  // given bounding box. Here, the bounding box is given by the coordinates of
  // its left, top, right, and bottom.
  private static boolean almostContainsPoint(Point p, int left, int top,
      int right, int bottom, double tolerance) {
    return p.x >= left - tolerance && p.y >= top - tolerance
        && p.x <= right + tolerance && p.y <= bottom + tolerance;
  }

  // Helper method that returns the distance from Point p to the line
  // containing a line segment whose endpoints are given.
  private static double distanceToPoint(Point p, int x1, int y1, int x2,
      int y2) {
    if (x1 == x2) // vertical segment?
      return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
    else if (y1 == y2) // horizontal segment?
      return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
    else {
      // Here, we know that the segment is neither vertical nor
      // horizontal.
      // Compute m, the slope of the line containing the segment.
      double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

      // Compute mperp, the slope of the line perpendicular to the
      // segment.
      double mperp = -1.0 / m;

      // Compute the (x, y) intersection of the line containing the
      // segment and the line that is perpendicular to the segment and that
      // contains Point p.
      double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
          / (mperp - m);
      double y = m * (x - x1) + y1;

      // Return the distance between Point p and (x, y).
      return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
  }
}
