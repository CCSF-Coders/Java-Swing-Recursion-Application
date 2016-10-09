import java.awt.Color;
import java.awt.Graphics2D;
/**
 * A GraphicShape interface describes the operations of the graphic shape, and allow user to use. 
 * 
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
 */
public interface GraphicShape {
	/** Custom painting used in GraphicsPolygon class.
	    @param g 
	    	The object to get the method in GraphicsPolygon class.*/
	public void paintComponent(Graphics2D g);
	
	/** To make the shape recursive.
	    @param baseShape 
	    	The object take the base shape.*/
	public void recurseShape(GraphicShape baseShape);
	
	/** Gets the x point.
	    @return the x point.*/
	public int[] getXPoints();
	
	/** Gets the y point.
	    @return the y point.*/
	public int[] getYPoints();
	
	/** Gets the shape's radius.
	    @return the integer of the shape's radius.*/
	public int getRadius();
	public boolean getColorChange();
	
	/** Gets the colors.
	    @return the color which we invoke.*/
	public Color getColor();
	
	/** Gets the sides of th shape.
	    @return the sides.*/
	public int getSides();
	
	/** Makes the  shape do rotation.
	    @return the rotation.*/
	public double getRotation();
	
	/** Gets the recursion factor.
	    @return the recursion factor.*/
	public double getRecursionFactor();
	
	/** To set the point of the shape
	    @param i 
	    	The integer is the index of VertixShape.
	    @param g 
	    	The object to get the method in GraphicShape interface*/
	public void setVertixShape(int i, GraphicShape p);
	
	/** A new GraphicShape method take those param for a new shape.
	    @param color	
	    	@return color.
	    @param sides, Point center		
	    	@return the side and point center of the new shape
	    @param radius	
	    	@return the radius of the new shape
	    @param rotation	
	    	@return the rotation of the new shape
	    @param recursionFactor	
	    	@return the recursionFactor of the new shape*/
	public GraphicShape newShape(boolean change,Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter);
	/** Gives back the counter/current iteration of the recursive call
		@return Returns the counter. 
	*/
	public int getCounter();
}