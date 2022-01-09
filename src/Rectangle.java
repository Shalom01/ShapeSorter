import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	
	public int width;
	public int height;

	public Rectangle(int upperX, int upperY, int width, int height, Color c) {
		super.upperX = upperX;
		super.upperY = upperY;
		this.height = height;
		this.width = width;
		super.c = c;
	}
	
	/*
	 * getSize() override's the abstract method of the abstract Shape class.
	 * It calculates and returns the size of the Rectangle as a double.  
	 */
	
	@Override
	public double getSize() {
		return width * height;
	}
	
	/*
	 * draw() override's the abstract draw() method of the abstract Shape class.
	 * It draws the Rectangle on the panel.
	 */
	
	@Override
	public void draw(Graphics g) {
		g.setColor(super.c);
		g.fillRect(super.upperX, super.upperY, width, height);
	}
}
