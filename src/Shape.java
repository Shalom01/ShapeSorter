import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable<Shape>{
	
	protected Color c; //the shapes color
	protected int upperX; //the upper-left point x
	protected int upperY; //the upper-left point y
	
	public abstract double getSize();
	public abstract void draw(Graphics g);
	
	//public setter methods
	public void setUpperY(int upperY) {
		this.upperY = upperY;
	}

	public void setUpperX(int upperX) {
		this.upperX = upperX;
	}

	public void setColor(Color c) {
		this.c = c;
	}
	
	//getters
	public int getUpperY() {
		return upperY;
	}
	
	public int getUpperX() {
		return upperX;
	}
	
	public Color getColor() {
		//defensive copy
		int value = c.getRGB();
		Color color = new Color(value);
		return color;
		
	}
	
	public int compareTo(Shape o) {
		if(o.getSize()>this.getSize()) {
			return 1;
		}else if(o.getSize()<this.getSize()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
