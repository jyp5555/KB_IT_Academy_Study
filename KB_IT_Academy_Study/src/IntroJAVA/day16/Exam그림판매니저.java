package IntroJAVA.day16;

import java.util.ArrayList;

public class Exam그림판매니저 {

	private ArrayList<Shape> shapeList = new ArrayList<>();
	
	public void add(Shape shape) {
		shapeList.add(shape);
	}
	
	public int getSize() {
		return shapeList.size();
	}
	
	public Shape getItemPos(int pos) {
		Shape result;
		try {
			result = shapeList.get(pos);
		}catch(NullPointerException e) {
			result = null;
		}catch(IndexOutOfBoundsException e1) {
			result = null;
		}
		return result;
	}
	
	public Shape findyByPosition(int x1, int y1) {
		for(Shape shape : shapeList) {
			if(shape.getStartX()== x1 && shape.getStartY() == y1) {
				return shape;
			}
		}
		return null;
	}
	
	public ArrayList<Shape> getAllItem() {
		return shapeList;
	}
	
}
