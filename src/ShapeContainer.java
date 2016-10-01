import java.awt.Graphics2D;

public class ShapeContainer {
	private int sides;
	private int radius;
	private int rotation;
	private int recurseFactor;
	private GraphicsPolygon basePolygon;
	public ShapeContainer() {
		sides = 4;
		radius = 150;
		rotation = 45;
		recurseFactor = 2;
		rebuild();
	}
	public void animateStep() {
		radius = radius - 2;
//		recurseFactor = (int)((250.0 - (double)radius) / 100.0)+2;
		if ( radius < 0 ) {
			radius = 150;
			sides++;
			if ( sides > 12 ) {
				sides = 3;
				radius = 150;
				rotation = 0;
			}
		}
		rotation = radius;
	}
	public void rebuild() {
		basePolygon = new GraphicsPolygon(sides, new Vertix(500/2, 500/2), radius, ((double)rotation)*(Math.PI*2.0)/360.0, recurseFactor);
		new RecursePolygons().recursePolygons(basePolygon);

	}
	public void paintComponents(Graphics2D g) {
		basePolygon.paintComponent(g);
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	public int getRecurseFactor() {
		return recurseFactor;
	}
	public void setRecurseFactor(int recurseFactor) {
		this.recurseFactor = recurseFactor;
	}
	public GraphicsPolygon getBasePolygon() {
		return basePolygon;
	}
	public void setBasePolygon(GraphicsPolygon basePolygon) {
		this.basePolygon = basePolygon;
	}
}
