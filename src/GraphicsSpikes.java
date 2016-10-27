import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
/**
 * A class for spikes shape, extend GraphicsBaseclass, 
 * and override GraphicShape interface which allow it to use the methods inside.
 *
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
 */
public class GraphicsSpikes extends GraphicsBaseclass {
	private final GraphicShape[] vertixCircles;

	private Polygon[] spikes;
	private int[] xVertices;
	private int[] yVertices;
	
	//constructor for GraphicsSpikes class, invoke the instance data from ShapeContainer
	public GraphicsSpikes(boolean change, Color color,int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixCircles = new GraphicsSpikes[sides];
		spikes = new Polygon[sides];
		
		//calculation for spikes 
		double slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		
		rotation = rotation * (counter+1);
		
		for ( int s=0; s < sides; ++s ){
			xVertices[s] = (int)(center.getX()-(Math.cos((double)s*slice+rotation)*radius));
			yVertices[s] = (int)(center.getY()-(Math.sin((double)s*slice+rotation)*radius));
			int[] xspikes = new int[3]; //create new index for position 3
			int[] yspikes = new int[3];
			xspikes[0] = (int)(center.getX()-(Math.cos((double)s*slice+(rotation+Math.PI/2))*(radius/10+1)));
			yspikes[0] = (int)(center.getY()-(Math.sin((double)s*slice+(rotation+Math.PI/2))*(radius/10+1)));
			xspikes[1] = (int)(center.getX()-(Math.cos((double)s*slice+rotation)*(radius*1.5)));
			yspikes[1] = (int)(center.getY()-(Math.sin((double)s*slice+rotation)*(radius*1.5)));
			xspikes[2] = (int)(center.getX()-(Math.cos((double)s*slice+(rotation-Math.PI/2))*(radius/10+1)));
			yspikes[2] = (int)(center.getY()-(Math.sin((double)s*slice+(rotation-Math.PI/2))*(radius/10+1)));
			spikes[s] = new Polygon( xspikes, yspikes, 3);
		}
	}

	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(this.color);
		for ( int s=0; s < sides; ++s ) {
			g.setColor(this.color);
			g.fillPolygon(spikes[s]);
//			g.setColor(Color.GRAY);
//			g.drawPolygon(spikes[s]);
			
		}
		for ( GraphicShape vertixCircle: vertixCircles ) {
			if ( vertixCircle != null ) vertixCircle.paintComponent(g);
		}
	}
	
	@Override
	public void setVertixShape(int index, GraphicShape graphicShape) {
		vertixCircles[index] = graphicShape;
	}
	@Override
	public int[] getXPoints() {
		return xVertices;
	}
	@Override
	public int[] getYPoints() {
		return yVertices;
	}

	@Override
	public GraphicShape newShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		return new GraphicsSpikes(colorChange, color, sides, center, radius, rotation, recursionFactor, counter);
	}

}