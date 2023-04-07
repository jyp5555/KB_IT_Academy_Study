package IntroJAVA.day16;

import java.util.Arrays;

/*
 * 1. VO/DTO: 데이터 저장용 클래스, 학생정보, 상품정보
 * 2. DAO: VO를 관리하는 기능 제공 crud, 데이터 관련 비즈니스로직
 * 3. UI: View 화면 표현 ->MVVM 여러 디자인패턴 있음... 
 * 4. IO, Repository: DAO 내 저장소 저장 로딩, 파일, db, 네트워크서버
 */

public class Exam그림판 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//선, 사각형, 원
		//점 : startX, startY
		//선 Line: startX, startY, endX, endY 두 점을 잇는다.
		//사각형 Rectangle: startX, startY, width, height
		//원 Circle: startX, startY, radius
		
		Line l = new Line(0,0,1,1);
		Circle c = new Circle(0,0,2);
		
		Exam그림판매니저 msm = new Exam그림판매니저();
		msm.add(l); msm.add(c);
		System.out.println(msm.getSize());
		System.out.println(Arrays.deepToString(msm.getAllItem().toArray()));
		Polygon p = new Polygon(0, 0, 5, new int[] {1,1}, new int[] {2,2});
		System.out.println(((Shape)l).equals(new Shape(0,0)));
	}

}

class Shape{
	private int startX;
	private int startY;
	
	public Shape(int startX, int startY) {
		super();
		this.startX = startX;
		this.startY = startY;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	@Override
	public String toString() {
		return super.toString()+ "startX=" + startX + ", startY=" + startY;
	}
}

class Line extends Shape{
	
	private int endX;
	private int endY;
	
	public Line(int startX, int startY, int endX, int endY) {
		super(startX, startY);
		this.endX = endX;
		this.endY = endY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getendY() {
		return endY;
	}

	public void setendY(int endY) {
		this.endY = endY;
	}

	@Override
	public String toString() {
		return super.toString()+ "endX=" + endX + ", endY=" + endY ;
	}
}

class Rectangle extends Shape{
	
	private int width;
	private int height;
	
	public Rectangle(int startX, int startY, int width, int height) {
		super(startX, startY);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString()+"width=" + width + ", height=" + height ;
	}
}

class Circle extends Shape{
	
	private int radius;
	
	public Circle(int startX, int startY, int radius) {
		super(startX, startY);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
	public String toString() {
		return super.toString()+"radius=" +radius ;
	}
}
class Polygon extends Shape{
	private int pointCount;
	private int[] x;
	private int[] y;
	
	public Polygon(int startX, int startY, int pointCount, int[] x, int[] y) {
		super(startX, startY);
		this.pointCount = pointCount;
		this.x = x;
		this.y = y;
	}
}


