import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
/**
 * This class is circle shape, it extends GraphicsBaseclass as its child class.
 *
 */

public class GraphicsCircles extends GraphicsBaseclass {
	private int[] xVertices;
	private int[] yVertices;
	private GraphicShape[] vertixCircles;

	private double slice;
	private final Ellipse2D.Float ellipse;

	public GraphicsCircles(boolean change, Color color,int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixCircles = new GraphicsCircles[sides]; 
		
		//calculate the x, y vertices
		slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		vertixCircles = new GraphicShape[sides];

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

	/** Gets the x point.
	    @return the x point.*/
	@Override
	public int[] getXPoints() {
		return this.xVertices;
	}
	
	/** Gets the y point.
	    @return the y point.*/
	@Override    
	public int[] getYPoints() {
		return this.yVertices;
	}
	
	/** To set the point of the shape
	    @param i 
	    	The integer is the index of VertixShape.
	    @param g 
	    	The object to get the method in GraphicShape interface*/
	@Override
	public void setVertixShape(int index, GraphicShape graphicShape) {
		vertixCircles[index] = graphicShape;
	}

	@Override
	public GraphicShape newShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		return new GraphicsCircles(colorChange, color, sides, center, radius, rotation, recursionFactor, counter);
	}

}
