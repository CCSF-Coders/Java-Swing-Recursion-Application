import javax.swing.JPanel;

public class Animation implements Runnable {
	private ShapeContainer shapeContainer;
	private JPanel drawingPanel;
	private boolean animate;
	public Animation(ShapeContainer shapeContainer, JPanel drawingPanel) {
		this.shapeContainer = shapeContainer;
		this.drawingPanel = drawingPanel;
	}
	@Override
	public void run() {
		while ( animate ) {
			shapeContainer.animateStep();
			shapeContainer.rebuild();
			drawingPanel.repaint();
			try {
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
