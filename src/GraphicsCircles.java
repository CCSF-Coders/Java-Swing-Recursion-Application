import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
/**
 * This class is circle shape, it extends GraphicsBaseclass as its child class.
 * *
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
 */

public class GraphicsCircles extends GraphicsBaseclass {
	private final GraphicShape[] vertixCircles;

	private final Ellipse2D.Float ellipse;
	private int[] xVertices;
	private int[] yVertices;

	//circle constructor, invoke the instance data from ShapeContainer
	public GraphicsCircles(boolean change, Color color,int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixCircles = new GraphicsCircles[sides]; 
		
		//calculate the x, y vertices
		double slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		
		rotation = rotation * (counter+1);
		
		for ( int s=0; s < sides; ++s ) {
			xVertices[s] = (int)(center.getX()-(Math.cos((double)s*slice+rotation)*radius));
			yVertices[s] = (int)(center.getY()-(Math.sin((double)s*slice+rotation)*radius));
		}
		ellipse = new Ellipse2D.Float(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
	}
	
	//override the methods in paintComponent interface
	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(Color.GRAY);
		g.draw(ellipse);
		g.setColor(this.color);
		g.fill(ellipse);
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
		return new GraphicsCircles(colorChange, color, sides, center, radius, rotation, recursionFactor, counter);
	}

}