import javax.swing.JPanel;
/**
 * This class implements Runnable, a functional interface, which instances are intended to be executed by a thread.
 * A must defined method of no arguments called run should be exist.
 * 
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
 */

public class Animation implements Runnable {
	private ShapeContainer shapeContainer;
	private JPanel drawingPanel;
	private boolean animate;
	
	//a constructor to take all the instance data
	public Animation(ShapeContainer shapeContainer, JPanel drawingPanel) {
		this.shapeContainer = shapeContainer;
		this.drawingPanel = drawingPanel;
	}
	
	//override run method from runnable
	@Override
	public void run() {
		while ( animate ) { //while loop to check animate condition
			shapeContainer.animateStep();
			shapeContainer.rebuild();
			drawingPanel.repaint();
			try { //try-catch any thread
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean isAnimate() {
		return animate;
	}
	public void setAnimate(boolean animate) {
		this.animate = animate;
	}
}
