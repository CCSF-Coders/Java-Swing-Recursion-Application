
public abstract class GraphicsBaseclass implements GraphicShape {
	@Override
	public void recurseShape(GraphicShape baseShape) {
		if ( baseShape.getRadius() > 10 ) {
			int[] xpoints = baseShape.getXPoints();
			int[] ypoints = baseShape.getYPoints();
			for ( int i=0; i < xpoints.length; ++i ) {
				GraphicShape p = baseShape.newShape(
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
