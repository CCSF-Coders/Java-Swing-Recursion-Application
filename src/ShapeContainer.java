import java.awt.Graphics2D;

import java.awt.Color;

public class ShapeContainer {
	private Color color;
	private int sides;
	private int radius;
	private int rotation;
	private int recurseFactor;
<<<<<<< 89f19258788f139c75fa2a004f84b89167660acd
	private GraphicsBaseclass baseShape;
=======
	private GraphicsPolygon basePolygon;
	private boolean colorChange;
>>>>>>> Color changed
	enum ADIR{INC, DEC};
	private ADIR aDir;
	private RecursionProgram.SHAPES shape;
	
	public ShapeContainer() {
		colorChange = true;	
		color = Color.RED;
		sides = 4;
		radius = 150;
		rotation = 45;
		recurseFactor = 2;
		aDir = ADIR.DEC;
		shape = RecursionProgram.SHAPES.Polygon;
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
			if ( radius > 180  ) {
				aDir = ADIR.DEC;
			}
		}
		rotation = radius;
	}
	public void rebuild() {
<<<<<<< 89f19258788f139c75fa2a004f84b89167660acd
		switch ( shape ) {
		case Circle:
			baseShape = new GraphicsCircles(color ,sides, new Point(500/2, 500/2), radius, ((double)rotation)*(Math.PI*2.0)/360.0, recurseFactor);
			break;
		case Polygon:
			baseShape = new GraphicsPolygon(color ,sides, new Point(500/2, 500/2), radius, ((double)rotation)*(Math.PI*2.0)/360.0, recurseFactor);
			break;
		default:
			break;
		
		}
		baseShape.recurseShape(baseShape);
=======
		basePolygon = new GraphicsPolygon(colorChange, color,sides, new Vertix(500/2, 500/2), radius, ((double)rotation)*(Math.PI*2.0)/360.0, recurseFactor);
		new RecursePolygons().recursePolygons(basePolygon);
>>>>>>> Color changed

	}
	public void paintComponents(Graphics2D g) {
		baseShape.paintComponent(g);
	}
	public void setColorChange(boolean change){
		this.colorChange = change;
	}
	public boolean getColorChange(){
		return this.colorChange; 
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
	public RecursionProgram.SHAPES getShape() {
		return shape;
	}
	public void setShape(RecursionProgram.SHAPES shape) {
		this.shape = shape;
	}
}
