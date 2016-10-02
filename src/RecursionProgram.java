
/*
 * HelloWorldSwing.java requires no other files. 
 */

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

@SuppressWarnings("serial")
public class RecursionProgram extends JFrame implements ActionListener {
	private JComboBox<String> chooseColors;
	private JComboBox<Integer> chooseSides;
	private JComboBox<Integer> chooseRadius;
	private JComboBox<Integer> chooseRotation;
	private JComboBox<Integer> chooseRecurseFactor;
	private JButton runAnimation;
	private DrawingPanel drawingPanel;
	private ShapeContainer shapeContainer;
	private Animation animation;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource().equals(chooseSides) ) {
			shapeContainer.setSides( ((Integer)chooseSides.getSelectedItem()).intValue() );
		}
		else if (e.getSource().equals(chooseRadius) ) {
			shapeContainer.setRadius( ((Integer)chooseRadius.getSelectedItem()).intValue() );
		}
		else if(e.getSource().equals(chooseColors)){
			String selection = (String)chooseColors.getSelectedItem();
			if(selection.equals("Red")){
				shapeContainer.setColor(Color.RED);
			}
			if(selection.equals("Green")){
				shapeContainer.setColor(Color.GREEN);
			}
			if(selection.equals("Blue")){
				shapeContainer.setColor(Color.BLUE);
			}
		}
		else if ( e.getSource().equals(chooseRotation) ) {
			shapeContainer.setRotation( ((Integer)chooseRotation.getSelectedItem()).intValue() );
		}
		else if ( e.getSource().equals(chooseRecurseFactor) ) {
			shapeContainer.setRecurseFactor( ((Integer)chooseRecurseFactor.getSelectedItem()).intValue() );
		}
		else if ( e.getSource().equals(runAnimation) ) {
	    	if ( !animation.isAnimate() ) {
	    		runAnimation.setText("Stop Animation");
	    		animation.setAnimate(true);
				new Thread(animation).start();
			} else {
				animation.setAnimate(false);
	    		runAnimation.setText("Start Animation");
	        	setControls();
			}
		}
		shapeContainer.rebuild();
		drawingPanel.repaint();
	}
	private class DrawingPanel extends JPanel {
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    if( shapeContainer != null ) shapeContainer.paintComponents((Graphics2D)g);
		  }
	}
	    
	public void addComponentsToPane(Container pane) {
        
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }

        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        drawingPanel = new DrawingPanel();
	    drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setPreferredSize(new Dimension(500, 500));
        pane.add(drawingPanel, BorderLayout.CENTER);
         
        JPanel buttonPane = new JPanel();
        pane.add(buttonPane, BorderLayout.SOUTH);

        buttonPane.add(new JLabel("Color"));
        chooseColors = new JComboBox<String>(new String[]{"Red", "Green", "Blue"});
        buttonPane.add(chooseColors);
        chooseColors.addActionListener(this);

    	buttonPane.add(new JLabel("Sides"));
    	chooseSides = new JComboBox<Integer>(new Integer[] {3,4,5,6,7,8,9,10,11,12});
    	buttonPane.add(chooseSides);
    	chooseSides.addActionListener(this);

    	buttonPane.add(new JLabel("Radius"));
    	chooseRadius = new JComboBox<Integer>(new Integer[] {50,100,150,200,250});
    	buttonPane.add(chooseRadius);
    	chooseRadius.addActionListener(this);

    	buttonPane.add(new JLabel("Rotation"));
    	chooseRotation = new JComboBox<Integer>(new Integer[] {0,30,45,60,90});
    	buttonPane.add(chooseRotation);
    	chooseRotation.addActionListener(this);

    	buttonPane.add(new JLabel("Factor"));
    	chooseRecurseFactor = new JComboBox<Integer>(new Integer[] {2,3,4,5,6,7,8});
    	buttonPane.add(chooseRecurseFactor);
    	chooseRecurseFactor.addActionListener(this);

    	runAnimation = new JButton("Start Animation");
    	buttonPane.add(runAnimation);
    	runAnimation.addActionListener(this);

    	shapeContainer = new ShapeContainer(); 
    	setControls();
		// animation
		animation = new Animation(shapeContainer, drawingPanel);
		animation.setAnimate(false);
    }
	private void setControls() {
		chooseColors.setSelectedItem(shapeContainer.getColor());
		chooseSides.setSelectedItem(shapeContainer.getSides());
		chooseRadius.setSelectedItem(shapeContainer.getRadius());
		chooseRotation.setSelectedItem(shapeContainer.getRotation());
		chooseRecurseFactor.setSelectedItem(shapeContainer.getRecurseFactor());
	}
	private void createAndShowGUI() {
         
        //Create and set up the window.
        setTitle("Grapical Recursion");
        //Set up the content pane.
        addComponentsToPane(getContentPane());
        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());
        //Display the window.
        pack();
        setVisible(true);
        //take up the default look and feel specified by windows themes
        setDefaultLookAndFeelDecorated(true);

        //make the window startup position be centered
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);    
    }         

	public void run() {         
	    //Schedule a job for the event dispatch thread:
	    //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	public static void main(String[] args) {
		new RecursionProgram().run();
	}
}