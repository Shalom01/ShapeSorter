

public final class SortingTechnique {
		
	/*
	 * static method that sorts an array of Shape objects by their size using Insertion sort.
	 * It sorts both the array position, and the (X,Y) positions.
	 */
	
	public static void sortShapes(Shape[] shapes) {
		int i = 1; 
		while(i < shapes.length) {
			int j = i;
			while(j > 0 && (shapes[j-1].getSize() > shapes[j].getSize())) {
				//swap the shapes in the array
				Shape temp = shapes[j];
				shapes[j] = shapes[j-1];
				shapes[j-1] = temp;
				
				//swap their (X,Y) positions
				int upperX = shapes[j].getUpperX(); 
				int upperY = shapes[j].getUpperY();
				
				shapes[j].setUpperX(shapes[j-1].getUpperX());
				shapes[j].setUpperY(shapes[j-1].getUpperY());
				shapes[j-1].setUpperX(upperX);
				shapes[j-1].setUpperY(upperY);
				j--; //iterate
			}
			i++;
		}
	}
}
