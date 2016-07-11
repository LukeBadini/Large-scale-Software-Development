import java.awt.*;

/**
 * DeleteCmd.java
 * Command class to perform a delete command.
 * 
 * @author Luke A. Badini
 * @see Command
 */


public class DeleteCmd extends Command {
	
	/**
	 * When the mouse is clicked, find the front-most Shape in the drawing
     * that contains the mouse position. If there is such a Shape, then
     * removes it from the Drawing.
     * 
     * @param p the coordinates of the click
     * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) {
		dwg.deleteFrontmostShape(p);	
		return;
	}
}