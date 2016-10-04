import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class GraphicsPolygon extends GraphicsBaseclass {
	private final GraphicShape[] vertixPolygons;

	private final Color color;
	private final Polygon polygon;
	private final int radius, sides;
	private final Point center;
	private final double rotation;
	private final double recursionFactor;
	private int[] xVertices;
	private int[] yVertices;

	public GraphicsPolygon(Color color,int sides, Point center, int radius, double rotation, double recursionFactor) {
		this.color = color;
		this.radius = radius;
		this.center = center;
		this.sides = sides;
		this.rotation = rotation;
		this.recursionFactor = recursionFactor; 
		vertixPolygons = new GraphicsPolygon[sides]; 

		double slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		
		for ( int s=0; s < sides; ++s ) {
			xVertices[s] = (int)(center.getX()-(Math.cos((double)s*slice+rotation)*radius));
			yVertices[s] = (int)(center.getY()-(Math.sin((double)s*slice+rotation)*radius));
		}
		polygon = new Polygon( xVertices, yVertices, sides);
	}

	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(this.color);
		g.fillPolygon(polygon);
		g.setColor(Color.GRAY);
		g.drawPolygon(polygon);
		for ( GraphicShape vertixPolygon: vertixPolygons ) {
			if ( vertixPolygon != null ) vertixPolygon.paintComponent(g);
		}
	}
	public Color getColor(){
		return color;
	}
	public Polygon getPolygon() {
		return polygon;
	}
	public int getRadius() {
		return radius;
	}
	public int getSides() {
		return sides;
	}
	public Point getCenter() {
		return center;
	}
	public double getRotation() {
		return rotation;
	}
	public double getRecursionFactor() {
		return recursionFactor;
	}
	public void setVertixShape(int index, GraphicShape graphicShape) {
		vertixPolygons[index] = graphicShape;
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
	public GraphicShape newShape(Color color, int sides, Point center, int radius, double rotation, double recursionFactor) {
		return new GraphicsPolygon(color, sides, center, radius, rotation, recursionFactor);
	}

}
