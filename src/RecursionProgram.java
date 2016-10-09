
/*
 * Driver program for the recursion lab.
 *
 * Is the GUI and main executable for the application. 
 * 
 * Holds a ShapeContainer class, which acts on all the settings and holds 
 * the base GraphicShape instance.    
 * 
 * Holds an Animation class which will animate the current shape if
 * started in a Thread. 
 *
 * @author Karl Nicholas
 * @author Calvin Lee
 * @author Yu-Hsiang Huang
 */

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

@SuppressWarnings("serial")
public class RecursionProgram extends JFrame implements ActionListener {
	private JCheckBox colorChange;
	private JComboBox<COLORS> chooseColors;
	private JComboBox<Integer> chooseSides;
	private JComboBox<Integer> chooseRadius;
	private JComboBox<Integer> chooseRotation;
	private JComboBox<Integer> chooseRecurseFactor;
	private JComboBox<SHAPES> chooseShape;
	private JButton runAnimation;
	private DrawingPanel drawingPanel;
	private ShapeContainer shapeContainer;
	private Animation animation;
	public static enum SHAPES { Polygon, Circle, Spikes, Curves }; 
	public static enum COLORS { Red, Green, Blue, Black }; 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource().equals(chooseSides) ) {
			shapeContainer.setSides( ((Integer)chooseSides.getSelectedItem()).intValue() );
		}
		else if (e.getSource().equals(chooseRadius) ) {
			shapeContainer.setRadius( ((Integer)chooseRadius.getSelectedItem()).intValue() );
		}
		else if(e.getSource().equals(colorChange)){
			shapeContainer.setColorChange(colorChange.isSelected());
			chooseColors.setEnabled(!colorChange.isSelected());
		}
		else if(e.getSource().equals(chooseColors)){
			COLORS selection = (COLORS) chooseColors.getSelectedItem();
			if(selection.equals(COLORS.Red)){
				shapeContainer.setColor(Color.RED);
			}
			if(selection.equals(COLORS.Green)){
				shapeContainer.setColor(Color.GREEN);
			}
			if(selection.equals(COLORS.Blue)){
				shapeContainer.setColor(Color.BLUE);
			}
			if(selection.equals(COLORS.Black)){
				shapeContainer.setColor(Color.BLACK);
			}
		}
		else if ( e.getSource().equals(chooseRotation) ) {
			shapeContainer.setRotation( ((Integer)chooseRotation.getSelectedItem()).intValue() );
		}
		else if ( e.getSource().equals(chooseRecurseFactor) ) {
			shapeContainer.setRecurseFactor( ((Integer)chooseRecurseFactor.getSelectedItem()).intValue() );
		}
		else if ( e.getSource().equals(chooseShape) ) {
			shapeContainer.setShape( (SHAPES)chooseShape.getSelectedItem() );
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
         
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        chooseColors = new JComboBox<COLORS>(COLORS.values());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(new JLabel("Color"), c);
        c.gridx = 1;
        buttonPanel.add(chooseColors);
        chooseColors.addActionListener(this);

        pane.add(buttonPanel, BorderLayout.SOUTH);
        colorChange = new JCheckBox("Color Shift", true);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        buttonPanel.add(colorChange, c);
        colorChange.addActionListener(this);

        chooseSides = new JComboBox<Integer>(new Integer[] {3,4,5,6,7,8,9,10,11,12});
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
    	buttonPanel.add(new JLabel("Number of Sides"), c);
        c.gridx = 1;
    	buttonPanel.add(chooseSides, c);
    	chooseSides.addActionListener(this);

    	chooseRadius = new JComboBox<Integer>(new Integer[] {50,100,150,200,250});
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
    	buttonPanel.add(new JLabel("Radius of Shape"), c);
        c.gridx = 1;
    	buttonPanel.add(chooseRadius, c);
    	chooseRadius.addActionListener(this);

    	chooseRotation = new JComboBox<Integer>(new Integer[] {0,30,45,60,90});
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
    	buttonPanel.add(new JLabel("Rotation Amount"), c);
        c.gridx = 1;
    	buttonPanel.add(chooseRotation, c);
    	chooseRotation.addActionListener(this);

    	chooseRecurseFactor = new JComboBox<Integer>(new Integer[] {2,3,4,5,6,7,8});
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
    	buttonPanel.add(new JLabel("Recursion Division"), c);
        c.gridx = 1;
    	buttonPanel.add(chooseRecurseFactor, c);
    	chooseRecurseFactor.addActionListener(this);

        buttonPanel = new JPanel();
        pane.add(buttonPanel, BorderLayout.NORTH);

    	buttonPanel.add(new JLabel("Shapes"));
    	chooseShape = new JComboBox<SHAPES>(SHAPES.values());
    	buttonPanel.add(chooseShape);
    	chooseShape.addActionListener(this);

        runAnimation = new JButton("Start Animation");
    	buttonPanel.add(runAnimation);
    	runAnimation.addActionListener(this);

    	shapeContainer = new ShapeContainer(); 
    	setControls();
		// animation
		animation = new Animation(shapeContainer, drawingPanel);
		animation.setAnimate(false);
    }
	private void setControls() {
		chooseColors.setSelectedItem(shapeContainer.getColor());
		chooseColors.setEnabled(!colorChange.isSelected());
		chooseSides.setSelectedItem(shapeContainer.getSides());
		chooseRadius.setSelectedItem(shapeContainer.getRadius());
		chooseRotation.setSelectedItem(shapeContainer.getRotation());
		chooseRecurseFactor.setSelectedItem(shapeContainer.getRecurseFactor());
		chooseShape.setSelectedItem(shapeContainer.getShape());
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
	public static void main(String[] args) {//main function for output the console
		new RecursionProgram().run();
	}
}
