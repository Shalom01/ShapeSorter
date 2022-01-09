import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	private int diameter; //the diameter of the Circle.
	
	protected Circle(int upperX, int upperY, int diameter, Color c) { //protected constructor
		super.upperX = upperX;
		super.upperY = upperY;
		super.c = c;
		this.diameter = diameter;
	}
	
	/*
	 * getSize() override's the abstract method of the abstract Shape class.
	 * It calculates and returns the size of the Circle as a double.  
	 */
	
	@Override
	public double getSize() {
		return (double) (Math.PI * ((diameter/2.0) * (diameter/2.0)));
	}
	
	/*
	 * draw() override's the abstract draw() method of the abstract Shape class.
	 * It draws the Circle on the panel.
	 */

	@Override
	public void draw(Graphics g) {
		g.setColor(super.c);
		g.fillOval(upperX, upperY, diameter, diameter);
	}
}
