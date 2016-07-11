import java.awt.*;

/**
 * BlueCmd.java
 * Command class to perform a blue command.
 * 
 * @author Luke A. Badini
 * @see Command
 */

public class BlueCmd extends Command{
	
	/**
	 * Whenever a shape under a given point is clicked,
	 * its color is changed to blue.
     * 
     * @param p the coordinates of the click
     * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) {
		Shape toChange = dwg.getFrontmostContainer(p);
		if (toChange != null) {
			toChange.setColor(Color.blue);
		}
		return;
	}
}
