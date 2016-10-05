
import java.awt.Color;
import java.awt.Graphics2D;

public interface GraphicShape {
	public void paintComponent(Graphics2D g);
	public void recurseShape(GraphicShape baseShape);
	public int[] getXPoints();
	public int[] getYPoints();
	public int getRadius();
	public boolean getColorChange();
	public Color getColor();
	public int getSides();
	public double getRotation();
	public double getRecursionFactor();
	public void setVertixShape(int i, GraphicShape p);
	public GraphicShape newShape(boolean change,Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter);
	public int getCounter();
}
