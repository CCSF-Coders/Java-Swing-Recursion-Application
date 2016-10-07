import java.awt.Color;
/**
 * This class is to create the graphics base and implements GraphicShape interface 
 * to use the methods inside.
 * 
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
 */
public abstract class GraphicsBaseclass extends GraphicShape {
		
	public GraphicsBaseclass(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		if (colorChange) {
			/*use switch to break other colors once we chose one
				the counters is tied to the number of recursive iterations.  
			*/ 
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
	
	/**
	 * Override the recurseShape from GraphicShape interface
	 * 
	 * implementation of recursion function. This will recursively build shapes dividing 
	 * the radius by the "recursionFactor" each time until the radius of a shape is less than
	 * 10 units.
	 * 
	 * @param baseShape GraphicShape to recurse. 
	 */
	@Override
	public void recurseShape(GraphicShape baseShape) {
		//if the radius > 10, the x&y point equals to baseShape
		if ( baseShape.getRadius() > 10 ) { 
			int[] xpoints = baseShape.getXPoints();
			int[] ypoints = baseShape.getYPoints();
			//use for loop to make the shape recursively
			for ( int i=0; i < xpoints.length; ++i ) { 
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

	/* Retrieves the counter needed to for the color change. 
		@return Returns the current counter.
	*/

	@Override
	public int getCounter() {
		return counter;
	}
}
