import java.awt.*;

/**
 * FrontCmd.java
 * Command class to perform a front command.
 * 
 * @author Luke A. Badini
 * @see Command
 */

public class FrontCmd extends Command{

	/**
	 * When the mouse is clicked, find the front-most Shape in the drawing
     * that contains the mouse position. If there is such a Shape, then
     * moves it to the front of the Drawing.
     * 
     * @param p the coordinates of the click
     * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) {
		if (dwg.getFrontmostContainer(p) != null) {
			dwg.moveToFront(p);
		}
		return;
	}
}
