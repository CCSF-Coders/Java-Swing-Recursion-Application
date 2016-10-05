import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class GraphicsPolygon extends GraphicsBaseclass {
	private final GraphicShape[] vertixPolygons;
	private final Polygon polygon;

	public GraphicsPolygon(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixPolygons = new GraphicsPolygon[sides];

		double slice = (2 * Math.PI) / ((double) sides);
		int[] xVertices = new int[sides];
		int[] yVertices = new int[sides];

		for (int s = 0; s < sides; ++s) {
			xVertices[s] = (int) (center.getX() - (Math.cos((double) s * slice + rotation) * radius));
			yVertices[s] = (int) (center.getY() - (Math.sin((double) s * slice + rotation) * radius));
		}
		polygon = new Polygon(xVertices, yVertices, sides);
	}

	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(this.color);
		g.fillPolygon(polygon);
		g.setColor(Color.GRAY);
		g.drawPolygon(polygon);
		for (GraphicShape vertixPolygon : vertixPolygons) {
			if (vertixPolygon != null)
				vertixPolygon.paintComponent(g);
		}
	}

	@Override
	public boolean getColorChange() {
		return colorChange;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getRadius() {
		return radius;
	}

	@Override
	public int getSides() {
		return sides;
	}

	@Override
	public double getRotation() {
		return rotation;
	}

	@Override
	public double getRecursionFactor() {
		return recursionFactor;
	}

	public void setVertixShape(int index, GraphicShape graphicShape) {
		vertixPolygons[index] = graphicShape;
	}

	@Override
	public int[] getXPoints() {
		return polygon.xpoints;
	}

	@Override
	public int[] getYPoints() {
		return polygon.ypoints;
	}

	@Override
	public GraphicShape newShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		return new GraphicsPolygon(colorChange, color, sides, center, radius, rotation, recursionFactor, counter);
	}
}
