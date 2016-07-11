import java.awt.*;


/**
 * Rectangle.java
 * Class for a rectangle.
 *
 * @author Luke A. Badini 
 * @see Shape
 */

public class Rectangle extends Shape {
	
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
	public Rectangle(Color c, int x, int y, int newWidth, int newHeight) {
		super(c);
		color = c;
		myX = x;
		myY = y;
		width = newWidth;
		height = newHeight;
		return;
	}
	
	/**
	 * Draws a rectangle on a given graphics object
	 * 
	 * @param page a given graphics object
	 */
	public void drawShape(Graphics page) {
		page.setColor(color);
		page.fillRect(myX, myY, width, height);
		return;
	}
	
	/**
	 * @return a point that corresponds to the center of the rectangle
	 */
	public Point getCenter() {
		int centerX = myX + (width/2);
		int centerY = myY + (height/2);
		return new Point(centerX, centerY);
	}
	
	/**
	 * Determines if a given point is within the rectangle
	 * 
	 * @return true if the point is in the rectangle
	 */
	public boolean containsPoint(Point p) {
		return pointInRectangle(p, myX, myY, width, height);
	}
	
	/**
	* Moves a rectangle
	* 
	* @param deltaX how much to move the ellipse in the x direction
	* @param deltaY how much to move the ellipse in the y direction
	*/
	public void move(int deltaX, int deltaY) {
		myX += deltaX;
		myY += deltaY;
		return;
	}
	
	/**
	 * Sets the value of myX for a Rectangle
	 * 
	 * @param x new value for myX
	 */
	public void setX(int x) {
		myX = x;
		return;
	}
	
	/**
	 * @return the value of myX for a Rectangle
	 */
	public int getX() {
		return myX;
	}
	
	/**
	 * Sets the value of myY for a Rectangle
	 * 
	 * @param y new value for myY
	 */
	public void setY(int y) {
		myY = y;
		return;
	}
	
	/**
	 * @return the value of myY for a Rectangle
	 */
	public int getY() {
		return myY;
	}
	
	/**
	 * Sets the width of a Rectangle to a new value
	 * 
	 * @param newWidth the new width of the Rectangle
	 */
	public void setWidth(int newWidth) {
		width = newWidth;
		return;
	}
	
	/**
	 * @return the width of a Rectangle
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the height of a Rectangle to a new value
	 * 
	 * @param newHeight the new height of the Rectangle
	 */
	public void setHeight(int newHeight) {
		height = newHeight;
		return;
	}
	
	/**
	 * @return the height of a Rectangle
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Private helper method that returns true if a given point is in
	 * a rectangle with the given top left corner and size
	 */
	private static boolean pointInRectangle(Point p, int left, int top, int width, 
			                                 int height) {
		return ((left <= p.x && p.x <= (left + width)) && (top <= p.y && p.y <= (top + height)));
	}
}
