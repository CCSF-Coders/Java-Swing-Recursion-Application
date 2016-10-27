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
	private final GraphicShape[] vertixPolygons;
	private final Polygon polygon;

	//constructor for GraphicsPolygon class, invoke the instance data from ShapeContainer
	public GraphicsPolygon(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixPolygons = new GraphicsPolygon[sides];
		
		//calculation for polygon shape
		double slice = (2 * Math.PI) / ((double) sides);
		int[] xVertices = new int[sides];
		int[] yVertices = new int[sides];

		rotation = rotation * (counter+1);
		
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
		for (GraphicShape vertixPolygon : vertixPolygons) {
			if (vertixPolygon != null)
				vertixPolygon.paintComponent(g);
		}
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