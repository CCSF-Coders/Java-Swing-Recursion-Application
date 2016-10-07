import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
/**
 * A class for polygon shape, extend GraphicsBaseclass, and override GraphicShape interface as well.
 *
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
 */
public class GraphicsPolygon extends GraphicsBaseclass {
	private int[] xVertices;
	private int[] yVertices;
	private GraphicShape[] vertixCircles;

	private double slice;
	private final Polygon polygon;

	//constructor for GraphicsPolygon class, invoke the instance data from ShapeContainer
	public GraphicsPolygon(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixCircles = new GraphicsPolygon[sides];

		//calculate the x, y vertices
		slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		vertixCircles = new GraphicShape[sides];
		for (int s = 0; s < sides; ++s) {
			xVertices[s] = (int) (center.getX() - (Math.cos((double) s * slice + rotation) * radius));
			yVertices[s] = (int) (center.getY() - (Math.sin((double) s * slice + rotation) * radius));
		}

		polygon = new Polygon(xVertices, yVertices, sides);

	}

	//override paintComponent interface for access the methods inside
	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(this.color);
		g.fillPolygon(polygon);
		g.setColor(Color.GRAY);
		g.drawPolygon(polygon);
		for (GraphicShape vertixPolygon : vertixCircles) {
			if (vertixPolygon != null)
				vertixPolygon.paintComponent(g);
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

	/*
		Overrides the GraphicShape method to take param for a polygon.
		@param change @return a boolean
	    @param color	@return color.
	    @param sides, Point center		@return the side and point center of the new shape
	    @param radius	@return the radius of the new shape
	    @param rotation	@return the rotation of the new shape
	    @param recursionFactor	@return the recursionFactor of the new shape
	*/
	
	@Override
	public GraphicShape newShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		return new GraphicsPolygon(colorChange, color, sides, center, radius, rotation, recursionFactor, counter);
	}
}
