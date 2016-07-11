import java.awt.*;
import java.lang.Math;

/**
 * RectCmd.java
 * Command class to perform a rectangle command.
 * 
 * @author Luke A. Badini
 * @see Command
 */

public class RectCmd extends Command {
	
	private Rectangle currentRect;
	private Point pressedPoint;
	
	/**
	 * When the mouse is pressed, sets pressedPoint to the mouse position and
	 * sets currentRect to a Rectangle at pressedPoint with width and height of 0.
	 * Then adds the shape to the Drawing.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executePress(Point p, Drawing dwg) {
		pressedPoint = p;
		currentRect = new Rectangle(dwg.getColor(), p.x, p.y, 0, 0);
		dwg.addShape(currentRect);
	}
	
	/**
	 * When the mouse is dragged, changes the coordinates of the top-left
	 * corner of the rectangle and the width/height of the rectangle.
	 * 
	 * @param p the coordinates of the drag
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (currentRect != null) {
			currentRect.setX(Math.min(p.x, pressedPoint.x));
			currentRect.setY(Math.min(p.y, pressedPoint.y));
			currentRect.setWidth(Math.abs(p.x - pressedPoint.x));
			currentRect.setHeight(Math.abs(p.y - pressedPoint.y));
		}
	}
}
