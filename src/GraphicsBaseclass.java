import java.awt.Color;
/**
 * This class is to create the grapgics base and implements GraphicShape interface 
 * to use the methods inside.
 *
 */
public abstract class GraphicsBaseclass implements GraphicShape {
	
	//use protected final to keep instance data for subclasses
	protected final boolean colorChange;
	protected final Color color;
	protected final int radius, sides;
	protected final double rotation;
	protected final double recursionFactor;
	protected int counter;
	
	public GraphicsBaseclass(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		this.colorChange = change;
		this.radius = radius;
		this.sides = sides;
		this.rotation = rotation;
		this.recursionFactor = recursionFactor;
		this.counter = counter;
		if (colorChange) {
/*			
			if (radius < 10) {
				this.color = Color.RED;
			} else if (radius >= 10 && radius < 20) {
				this.color = Color.YELLOW;
			} else if (radius >= 20 && radius < 40) {
				this.color = Color.GREEN;
			} else if (radius >= 40 && radius < 80) {
				this.color = Color.CYAN;
			} else if (radius >= 80 && radius < 160) {
				this.color = Color.BLUE;
			} else {
				this.color = Color.MAGENTA;
			}
*/			
			//use switch to break other colors once we chose one 
			switch (++this.counter) {
			case 1:
				this.color = Color.MAGENTA;
				break;
			case 2:
				this.color = Color.BLUE;
				break;
			case 3:
				this.color = Color.CYAN;
				break;
			case 4:
				this.color = Color.GREEN;
				break;
			case 5:
				this.color = Color.YELLOW;
				break;
			default:
				this.color = Color.RED;
				break;
			}
		} else {
			this.color = color;
		}
		
	}
	
	//override the recurseShape from GraphicShape interface
	@Override
	public void recurseShape(GraphicShape baseShape) {
		if ( baseShape.getRadius() > 10 ) { //if the radius > 10, the x&y point equals to baseShape
			int[] xpoints = baseShape.getXPoints();
			int[] ypoints = baseShape.getYPoints();
			for ( int i=0; i < xpoints.length; ++i ) { //use for loop to make the shape recursivly
				GraphicShape p = baseShape.newShape(
					baseShape.getColorChange(),
					baseShape.getColor(),
					baseShape.getSides(), 
					new Point(xpoints[i], ypoints[i]), 
					(int)((double)baseShape.getRadius()/baseShape.getRecursionFactor()), 
					baseShape.getRotation(), 
					baseShape.getRecursionFactor(), 
					baseShape.getCounter());
				baseShape.setVertixShape(i, p);
				recurseShape(p);
			}
		}
	}
	@Override
	public int getCounter() {
		return counter;
	}
}
