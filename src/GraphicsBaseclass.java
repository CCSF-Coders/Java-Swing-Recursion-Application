import java.awt.Color;

public abstract class GraphicsBaseclass implements GraphicShape {
	protected final boolean colorChange;
	protected final Color color;
	protected final int radius, sides;
	protected final double rotation;
	protected final double recursionFactor;
	
	public GraphicsBaseclass(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor) {
		this.colorChange = change;
		this.radius = radius;
		this.sides = sides;
		this.rotation = rotation;
		this.recursionFactor = recursionFactor;
		if (colorChange) {
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
		} else {
			this.color = color;
		}
		
	}

	@Override
	public void recurseShape(GraphicShape baseShape) {
		if ( baseShape.getRadius() > 10 ) {
			int[] xpoints = baseShape.getXPoints();
			int[] ypoints = baseShape.getYPoints();
			for ( int i=0; i < xpoints.length; ++i ) {
				GraphicShape p = baseShape.newShape(
					baseShape.getColorChange(),
					baseShape.getColor(),
					baseShape.getSides(), 
					new Point(xpoints[i], ypoints[i]), 
					(int)((double)baseShape.getRadius()/baseShape.getRecursionFactor()), 
					baseShape.getRotation(), 
					baseShape.getRecursionFactor());
				baseShape.setVertixShape(i, p);
				recurseShape(p);
			}
		}
	}
}
