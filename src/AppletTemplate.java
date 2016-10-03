import javax.swing.*;
import java.awt.*;

public class AppletTemplate extends JApplet {

	public void init() {
		setSize(500, 500);
		setBackground(Color.white);
	}

	public void paint(Graphics pen) {
		
		paintHelper(pen, 0, 0, 10, 10);
		//pen.fillRect(50,50,50,50);
	}
	
	//use a helper to make it recursive
	public void paintHelper(Graphics pen, int x, int y, int minWidth, int minHigh)
		if(h <= minHigh || w <= minWidth){
			return ;
		}
		
		int newWidth, newHigh;
		int newX, int newY;
		newWidth = (int) (minWidth * scaleFactor);
		newHigh  = (int) (minHigh  * scaleFactor);
		
		newX = x;
		newY = y;
		pen.drawRect(newX, newY, newMinWidth, newMinHigh);
		paintHelper(pen, minWidth, minHigh, newX, newY);
	
}
