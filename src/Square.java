import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{
	
	private int width; //width of the square
	
	protected Square(int upperX, int upperY, int width, Color c) { //protected constructor
		super.upperX = upperX;
		super.upperY = upperY;
		super.c = c;
		this.width = width;
	}
	
	/*
	 * getSize() override's the abstract method of the abstract Shape class.
	 * It calculates and returns the size of the Square as a double.  
	 */


	@Override
	public double getSize() {
		return width * width;
	}
	
	/*
	 * draw() override's the abstract draw() method of the abstract Shape class.
	 * It draws the Square on the panel.
	 */

	@Override
	public void draw(Graphics g) {
		g.setColor(super.c);
		g.fillRect(super.upperX, super.upperY, width, width);	
	}
}
