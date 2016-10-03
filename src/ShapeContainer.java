import java.awt.Graphics2D;
import java.awt.Color;

public class ShapeContainer {
	private Color color;
	private int sides;
	private int radius;
	private int rotation;
	private int recurseFactor;
	private GraphicsBaseclass baseShape;
	enum ADIR{INC, DEC};
	private ADIR aDir;
	public ShapeContainer() {
		color = Color.RED;
		sides = 4;
		radius = 150;
		rotation = 45;
		recurseFactor = 2;
		aDir = ADIR.DEC;
		rebuild();
	}
	public void animateStep() {
		if ( aDir == ADIR.DEC ) {
			radius = radius - 2;
			if ( radius < 0 ) {
				aDir = ADIR.INC;
				sides++;
				if ( sides > 12 ) {
					sides = 3;
				}
			}
		} else {
			radius = radius + 2;
			if ( radius > 150  ) {
				aDir = ADIR.DEC;
			}
		}
		rotation = radius;
	}
	public void rebuild() {
//		basePolygon = new GraphicsCircles(color ,sides, new Point(500/2, 500/2), radius, ((double)rotation)*(Math.PI*2.0)/360.0, recurseFactor);
//		new RecursePolygons().recursePolygons(basePolygon);
		baseShape = new GraphicsCircles(color ,sides, new Point(500/2, 500/2), radius, ((double)rotation)*(Math.PI*2.0)/360.0, recurseFactor);
		baseShape.recurseShape(baseShape);

	}
	public void paintComponents(Graphics2D g) {
		baseShape.paintComponent(g);
	}
	public void setColor(Color color){
		this.color = color; 
	}
	public Color getColor(){
		return color;
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
}
