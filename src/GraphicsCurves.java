import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
/**
 * This is for curves, it extends GraphicsBaseclass as its child class. 
 * Here also override GraphicShape interface to use those methods.
 */
public class GraphicsCurves extends GraphicsBaseclass {

	private CubicCurve2D.Float[] spikes;

	public GraphicsCurves(boolean change, Color color,int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixCircles = new GraphicsCurves[sides];
		spikes = new CubicCurve2D.Float[sides];
		
		for ( int s=0; s < sides; ++s ) {
			xVertices[s] = (int)(center.getX()-(Math.cos((double)s*slice+rotation)*radius));
			yVertices[s] = (int)(center.getY()-(Math.sin((double)s*slice+rotation)*radius));
			float x1 = center.getX();
			float y1 = center.getY();
			float ctrlx1 = (float) (center.getX()-(Math.cos((double)s*slice+(rotation+Math.PI/4))*(radius)));
			float ctrly1 = (float) (center.getY()-(Math.sin((double)s*slice+(rotation+Math.PI/4))*(radius)));
			float ctrlx2 = (float) (center.getX()-(Math.cos((double)s*slice+(rotation-Math.PI/4))*(radius)));
			float ctrly2 = (float) (center.getY()-(Math.sin((double)s*slice+(rotation-Math.PI/4))*(radius)));
			float x2 = (float)(center.getX()-(Math.cos((double)s*slice+rotation)*(radius)));
			float y2 = (float)(center.getY()-(Math.sin((double)s*slice+rotation)*(radius)));
			spikes[s] = new CubicCurve2D.Float(x1, y1, ctrlx1, ctrly1, ctrlx2, ctrly2, x2, y2);
		}
	}

	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(this.color);
		for ( int s=0; s < sides; ++s ) {
			g.setColor(this.color);
			g.fill(spikes[s]);
		}
		for ( GraphicShape vertixCircle: vertixCircles ) {
			if ( vertixCircle != null ) vertixCircle.paintComponent(g);
		}
	}

	/*@Override
	public GraphicShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		return new GraphicsCurves(colorChange, color, sides, center, radius, rotation, recursionFactor, counter);
	}*/

}
