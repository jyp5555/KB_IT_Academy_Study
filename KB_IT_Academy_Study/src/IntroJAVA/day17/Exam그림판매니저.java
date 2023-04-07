package IntroJAVA.day17;

import java.util.ArrayList;

public class Exam그림판매니저 {

	public static void main(String[] args) {
		ShapeManager msm = new ShapeManager();
		try {
			System.out.println(msm.findyByPosition(0, 0).toString());
		} catch (ShapeNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
}
class ShapeManager {
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
	
	/**
	 * @param x1
	 * @param y1
	 * @return
	 * @throws ShapeNotFoundException
	 */
	public Shape findyByPosition(int x1, int y1) throws ShapeNotFoundException {
		for(Shape shape : shapeList) {
			if(shape.getStartX()== x1 && shape.getStartY() == y1) {
				return shape;
			}
		}
//		return null; 사용자 정의 예외!
		/*
		 * throw: 예외객체 생성되었으니 자바 시스템에게 현재실행코드를 중단하고 긴급히 처리해달라는 연산자, 코드 실행중단, 메서드 반환
		 * throws: 선언문,Exception이 발생할지도 모르니 호출하는 코드에서 처리하는 코드 필요!
		 */
		throw new ShapeNotFoundException(x1, y1);
	}
	
	public ArrayList<Shape> getAllItem() {
		return shapeList;
	}
}
