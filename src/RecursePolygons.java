
public class RecursePolygons {
	public void recursePolygons(GraphicsPolygon basePolygon) {
		if ( basePolygon.getRadius() > 10 ) {
			int[] xpoints = basePolygon.getPolygon().xpoints;
			int[] ypoints = basePolygon.getPolygon().ypoints;
			for ( int i=0; i < xpoints.length; ++i ) {
				GraphicsPolygon p = new GraphicsPolygon(
					basePolygon.getColorChange(),
					basePolygon.getColor(),
					basePolygon.getSides(), 
					new Vertix(xpoints[i], ypoints[i]), 
					(int)((double)basePolygon.getRadius()/basePolygon.getRecursionFactor()), 
					basePolygon.getRotation(), 
					basePolygon.getRecursionFactor());
				basePolygon.setVertixPolygon(i, p);
				recursePolygons(p);
			}
		}
	}

}
