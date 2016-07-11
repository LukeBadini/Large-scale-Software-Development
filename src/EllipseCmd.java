import java.awt.*;
import java.lang.Math;

/**
 * EllipseCmd.java
 * Command class to perform a ellipse command.
 * 
 * @author Luke A. Badini
 * @see Command
 */

public class EllipseCmd extends Command {
	
	private Ellipse currentEllipse;
	private Point pressedPoint;
	
	/**
	 * When the mouse is pressed, sets pressedPoint to the mouse position and
	 * sets currentEllipse to an Ellipse at pressedPoint with width and height of 0.
	 * Then adds the shape to the Drawing.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executePress(Point p, Drawing dwg) {
		pressedPoint = p;
		currentEllipse = new Ellipse(dwg.getColor(), p.x, p.y, 0, 0);
		dwg.addShape(currentEllipse);
	}
	
	/**
	 * When the mouse is dragged, changes the coordinates of the top-left
	 * corner of the ellipse and the width/height of the ellipse.
	 * 
	 * @param p the coordinates of the drag
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (currentEllipse != null) {
			currentEllipse.setX(Math.min(p.x, pressedPoint.x));
			currentEllipse.setY(Math.min(p.y, pressedPoint.y));
			currentEllipse.setWidth(Math.abs(p.x - pressedPoint.x));
			currentEllipse.setHeight(Math.abs(p.y - pressedPoint.y));
		}
	}
}
