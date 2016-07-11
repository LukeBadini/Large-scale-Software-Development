import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform a move command.
 * 
 * @author Luke A. Badini
 * @see Command
 */

public class MoveCmd extends Command{
	
	private Shape toMove;
	
	/**
	 * When the mouse is pressed, sets toMove to the frontmost shape
	 * under the mouse press
	 * 
	 * @param p the coordinates of the mouse press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		toMove = dwg.getFrontmostContainer(p);
	}
	
	/**
	 * When the mouse is dragged, if there is a shape under the mouse
	 * press, it is moved by setting its center to p
	 * 
	 * @param p the coordinates of the mouse drag
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (toMove != null) {
			toMove.setCenter(p);
		}
		return;
	}
}
