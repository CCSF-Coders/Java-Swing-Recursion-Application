
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * A GraphicShape interface describes the operations of the graphic shape, and allow user to use. 
 * 
 * @author Karl Nicholas
 * @author Calvin 
 */
public class GraphicShape<T> {

	//use protected final to keep instance data for subclasses
	protected boolean colorChange;
	protected Color color;
	protected int radius, sides;
	protected double rotation;
	protected double recursionFactor;
	protected int counter;
	protected int[] xVertices;
	protected int[] yVertices;
	protected GraphicShape[]<T> vertixCircles;
	protected Point initCenter;
	protected double slice;
	

	/** A new GraphicShape method take those param for a new shape.
	    @param color	@return color.
	    @param sides, Point center		@return the side and point center of the new shape
	    @param radius	@return the radius of the new shape
	    @param rotation	@return the rotation of the new shape
	    @param recursionFactor	@return the recursionFactor of the new shape*/
	public GraphicShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter){
		this.colorChange = change;
		this.radius = radius;
		this.sides = sides;
		this.rotation = rotation;
		this.recursionFactor = recursionFactor;
		this.counter = counter;
		this.initCenter = center;

		//calculate the x, y vertices
		slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		vertixCircles = new T[sides];
		}
	/** Custom painting used in GraphicsPolygon class
	    @param g 
	    	The object to get the method in GraphicsPolygon class*/
	public void paintComponent(Graphics2D g){};
	
	/** To make the shape recursive
	    @param baseShape 
	    	The object take the base shape*/
	public void recurseShape(GraphicShape baseShape){};

	public void newShape(){};
	
	/** Gets the x point.
	    @return the x point.*/
	public int[] getXPoints() {
		return this.xVertices;
	}
	
	/** Gets the y point.
	    @return the y point.*/
	public int[] getYPoints() {
		return this.yVertices;
	}
	
	/** Gets the shape's radius.
	    @return the integer of the shape's radius.*/
	public int getRadius() {
		return this.radius;
	}

	/** Gets the choice of whether or not to change colors
		@return a boolean value to change colors or not.*/
	public boolean getColorChange(){
		return this.colorChange;
	}
	
	/** Gets the colors.
	    @return the color which we invoke.*/
	public Color getColor(){
		return this.color;
	}
	
	/** Gets the sides of th shape.
	    @return the sides.*/
	public int getSides() {
		return this.sides;
	}
	
	/** Makes the  shape do rotation.
	    @return the rotation.*/
	public double getRotation() {
		return this.rotation;
	}
	
	/** Gets the recursion factor.
	    @return the recursion factor.*/
	public double getRecursionFactor() {
		return this.recursionFactor;
	}
	
	/** To set the point of the shape
	    @param i 
	    	The integer is the index of VertixShape.
	    @param g 
	    	The object to get the method in GraphicShape interface*/
	public void setVertixShape(int index, GraphicShape graphicShape) {
		vertixCircles[index] = graphicShape;
	}

	/* Retrieves the counter needed to for the color change. 
		@return Returns the current counter.
	*/
	public int getCounter() {
		return this.counter;
	}

}
