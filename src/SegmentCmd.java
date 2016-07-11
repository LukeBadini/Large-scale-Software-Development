import java.awt.Point;

public class SegmentCmd extends Command {

	private Segment currentSeg;
	
	public void executePress(Point p, Drawing dwg) {
		currentSeg = new Segment(dwg.getColor(), p.x, p.y, p.x, p.y);
		dwg.addShape(currentSeg);
	}
	
	public void executeDrag(Point p, Drawing dwg) {
		if (currentSeg != null) {
			currentSeg.setX2(p.x);
			currentSeg.setY2(p.y);
		}
	}
}
