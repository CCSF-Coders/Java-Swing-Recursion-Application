import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class GraphicsPolygon implements GraphicShape {
	private final GraphicsPolygon[] vertixPolygons;

	private final Color color;
	private final Polygon polygon;
	private final int radius, sides;
	private final Vertix center;
	private final double rotation;
	private final double recursionFactor;

	public GraphicsPolygon(Color color,int sides, Vertix center, int radius, double rotation, double recursionFactor) {
		this.color = color;
		this.radius = radius;
		this.center = center;
		this.sides = sides;
		this.rotation = rotation;
		this.recursionFactor = recursionFactor; 
		vertixPolygons = new GraphicsPolygon[sides]; 

		double slice = (2*Math.PI)/((double)sides);
		int[] xVertices = new int[sides];
		int[] yVertices = new int[sides];
		
		for ( int s=0; s < sides; ++s ) {
			xVertices[s] = (int)(center.getX()+(Math.cos((double)s*slice+rotation)*radius));
			yVertices[s] = (int)(center.getY()+(Math.sin((double)s*slice+rotation)*radius));
		}
		polygon = new Polygon( xVertices, yVertices, sides);
	}

	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(this.color);
		g.fillPolygon(polygon);
		g.setColor(Color.GRAY);
		g.drawPolygon(polygon);
		for ( GraphicsPolygon vertixPolygon: vertixPolygons ) {
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
	public Vertix getCenter() {
		return center;
	}
	public double getRotation() {
		return rotation;
	}
	public double getRecursionFactor() {
		return recursionFactor;
	}
	public void setVertixPolygon(int index, GraphicsPolygon graphicsPolygon) {
		vertixPolygons[index] = graphicsPolygon;
	}
}
