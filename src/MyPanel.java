import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

	private Shape[] shapeBox = new Shape[6]; //array to hold our 6 Shapes
	private int upperX; //the upper leftmost x value to draw our Shapes 
	private int upperY;  //the upper leftmost y value to draw our Shapes
	private ShapeFactory factory = ShapeFactory.getInstance(); //the ShapeFactory singleton that allows us to generate random Shapes
	
	/*
	 * paintShapes is a public void method that:
	 * (1) Sets upperX and upperY to (150, 150) to begin painting from.
	 * (2) Paints the JPanel component (by calling super.paintComponent(g).
	 * (3) Fills our shapeBox will 6 random Shapes generated from our ShapeFactory singleton.
	 */
	
	public void paintShapes(Graphics g) {
		//we begin painting from (150, 150)
		upperX = 150;
		upperY = 150;
		
		super.paintComponent(g); //paint the JPanel component (parent component) on the window
		for(int i = 0; i < 6; i++) {
			shapeBox[i] = factory.getShape(upperX, upperY); //fill the array with Shape's
			shapeBox[i].draw(g); //draw the Shape
			//increment (x, y) 
			upperX+=100;
			upperY+=100;
		}
	}
	
	/*
	 *paintSortedShapes is a public void method that 
	 *(1) Paints the JPanel component (by calling super.painComponent(g).
	 *(2) Sorts the shapeBox by calling the static method sortShapes of the SortingTechnique class that sorts the Shapes by size.
	 *(3) Draws the sorted Shapes onto the panel.
	 */
	
	public void paintSortedShapes(Graphics g) {
		
		super.paintComponent(g); //paint the JPanel component (parent component on the window)
		
		SortingTechnique.sortShapes(shapeBox); //sort the shapeBox by the Shape sizes
		for(int i = 0; i < 6; i++) { //draw the Shapes from the now sorted Shape box
			shapeBox[i].draw(g);
		}
	}

	public static void main(String[] args) {
		MyPanel shapePanel = new MyPanel(); //MyPanel for generating + displaying the Shape's
		JPanel buttons = new JPanel(); //JPanel for the JButton components
		JFrame frame = new JFrame("Shape Sorter"); //the window frame of the application
		shapePanel.setSize(800,800); //set the size of the Shape's panel
		buttons.setSize(1000, 50); //set the size of the buttons panel
		
		//initialize buttons + set their text
		JButton load = new JButton(); 
		JButton sort = new JButton();
		load.setText("load shapes");
		sort.setText("sort shapes");
		
		load.addActionListener(new ActionListener(){ //adds ActionListener to load button that calls the paintShapes() method for our shapePanel
			public void actionPerformed(ActionEvent e) {
				shapePanel.paintShapes(shapePanel.getGraphics());
				buttons.repaint(); //repaint the buttons
			}
		});
		
		sort.addActionListener(new ActionListener(){ //adds ActionListener to sort button that calls the paintSortedShapes() method for our shapePanel
			public void actionPerformed(ActionEvent e) {
				shapePanel.paintSortedShapes(shapePanel.getGraphics());
				buttons.repaint(); //repaint the buttons
			}
		});
		
		//building the window
		buttons.add(sort);
		buttons.add(load);
		frame.add(buttons);
		frame.add(shapePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

