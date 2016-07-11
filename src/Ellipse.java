import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen 
 * @see Shape
 */
public class Ellipse extends Shape {
	
  private int myX;
  private int myY;
  private int width;
  private int height;
  private Color color;
  
  /**
   * Default constructor using the superclass constructor
   * 
   * @param c the color of the shape
   */
  public Ellipse(Color c, int x, int y, int newWidth, int newHeight) {
	  super(c);
	  color = c;
	  myX = x;
	  myY = y;
	  width = newWidth;
	  height = newHeight;
	  return;
  }
  
	/**
	 * Sets the value of myX for a Ellipse
	 * 
	 * @param x new value for myX
	 */
	public void setX(int x) {
		myX = x;
		return;
	}
	
	/**
	 * @return the value of myX for a Ellipse
	 */
	public int getX() {
		return myX;
	}
	
	/**
	 * Sets the value of myY for a Ellipse
	 * 
	 * @param y new value for myY
	 */
	public void setY(int y) {
		myY = y;
		return;
	}
	
	/**
	 * @return the value of myY for a Ellipse
	 */
	public int getY() {
		return myY;
	}
	
	/**
	 * Sets the width of a Ellipse to a new value
	 * 
	 * @param newWidth the new width of the Ellipse
	 */
	public void setWidth(int newWidth) {
		width = newWidth;
		return;
	}
	
	/**
	 * @return the width of a Ellipse
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the height of a Ellipse to a new value
	 * 
	 * @param newHeight the new height of the Ellipse
	 */
	public void setHeight(int newHeight) {
		height = newHeight;
		return;
	}
	
	/**
	 * @return the height of a Ellipse
	 */
	public int getHeight() {
		return height;
	}
  
  /**
   * Draws an ellipse on a given graphics object
   * 
   * @param page a given graphics object
   */
  public void drawShape(Graphics page) {
	  page.setColor(color);
	  page.fillOval(myX, myY, width, height);
	  return;
  }
  
  /**
   * @return a point that corresponds to the center of the ellipse
   */
  public Point getCenter() {
	  int centerX = myX + (width/2);
	  int centerY = myY + (height/2);
	  return new Point(centerX, centerY);
  }
  
  /**
   * @return true if a given point is in the ellipse,
   *         false otherwise
   */
  public boolean containsPoint(Point p) {
	  return pointInEllipse(p, myX, myY, width, height);
  }
  
  /**
   * Moves an ellipse
   * 
   * @param deltaX how much to move the ellipse in the x direction
   * @param deltaY how much to move the ellipse in the y direction
   */
  public void move(int deltaX, int deltaY) {
	  myX += deltaX;
	  myY += deltaY;
	  return;
  }
  
  // Helper method that returns whether Point p is in an Ellipse with the given
  // top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0; // half of the width
    double b = height / 2.0; // half of the height
    double centerx = left + a; // x-coord of the center
    double centery = top + b; // y-coord of the center
    double x = p.x - centerx; // horizontal distance between p and center
    double y = p.y - centery; // vertical distance between p and center

    // Now we just apply the standard geometry formula.
    // (See CRC, 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }
}
