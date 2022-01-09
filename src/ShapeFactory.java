import java.awt.Color;

//this class creates 
public class ShapeFactory {
	
	private static ShapeFactory uniqueFactory; //singleton implementation. ShapeFactory has a private static ShapeFactory that limits the instance count.
	private ShapeFactory() {} //singleton implementation. Restrict instatiation.
	
	public static ShapeFactory getInstance() { //singleton pattern implementation. getInstance() returns singleton instance if it exists. If not, it returns a new singleton.
		if(uniqueFactory==null) {
			uniqueFactory = new ShapeFactory();
		}
		return uniqueFactory;
	}
	
	/*
	 * public getter method getShape() that takes 
	 * two int values: upperX and upperY for the upper (x,y) position of the Shape.
	 */
	
	public Shape getShape(int upperX, int upperY) {
		
		Color c = new Color((int) (Math.random()*245 + 10), (int) (Math.random()*245) + 10, (int) (Math.random()*245) + 10); //generates a random Color (with a floor of 10, because of white background)
		double x = Math.random(); //generates a random double  0.0 < x < 1.0
		
		//based on the value of x, either return a new Circle, Square or Rectangle with a random width/diameter/height in the range of [25, 100]
		if(x < (1.0/3.0)) {
			return new Circle(upperX, upperY, (int) ((Math.random() * (100-25)) + 25), c);
		}else if(x < (2.0/3.0)) {
			return new Square(upperX, upperY, (int) ((Math.random() * (100-25)) + 25), c);
		}else {
			return new Rectangle(upperX, upperY, (int) ((Math.random() * (100-25)) + 25), (int) ((Math.random() * (100-25)) + 25), c);
		}
	}
}
