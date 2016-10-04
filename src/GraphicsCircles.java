import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class GraphicsCircles extends GraphicsBaseclass {
	private final GraphicShape[] vertixCircles;

	private final Color color;
	private final Ellipse2D.Float ellipse;
	private final int radius, sides;
	private final Point center;
	private final double rotation;
	private final double recursionFactor;
	private int[] xVertices;
	private int[] yVertices;

	public GraphicsCircles(Color color,int sides, Point center, int radius, double rotation, double recursionFactor) {
		this.color = color;
		this.radius = radius;
		this.center = center;
		this.sides = sides;
		this.rotation = rotation;
		this.recursionFactor = recursionFactor; 
		vertixCircles = new GraphicsCircles[sides]; 

		double slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		
		for ( int s=0; s < sides; ++s ) {
			xVertices[s] = (int)(center.getX()+(Math.cos((double)s*slice+rotation)*radius));
			yVertices[s] = (int)(center.getY()+(Math.sin((double)s*slice+rotation)*radius));
		}
		ellipse = new Ellipse2D.Float(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
	}

	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(this.color);
		g.draw(ellipse);
		for ( GraphicShape vertixCircle: vertixCircles ) {
			if ( vertixCircle != null ) vertixCircle.paintComponent(g);
		}
	}
	public Color getColor(){
		return color;
	}
	public Ellipse2D getPolygon() {
		return ellipse;
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
	public void setVertixPolygon(int index, GraphicShape graphicShape) {
		vertixCircles[index] = graphicShape;
	}

	public int[] getXPoints() {
		return xVertices;
	}

	public int[] getYPoints() {
		return yVertices;
	}

	@Override
	public GraphicShape newShape(Color color, int sides, Point center, int radius, double rotation, double recursionFactor) {
		return new GraphicsCircles(color, sides, center, radius, rotation, recursionFactor);
	}

}
