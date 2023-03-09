package IntroJAVA.day04;

public class ExamShape {
//	자바 그림판 제작
//	관리대상 도형정보, 선, 사각형, 원
//	Line(x1, y1, x2, y2), Rect(x1,y1,width, height), Circle(x1,y1,radius)
//	if Line[], Rect[], Circle[] 각각 저장 시, 껐다 키면 다시 뭐부터 그려야 할지 따로 정해주지 않아 모름..
	
	public static void main(String[] args) {
		Shape[] arr = new Shape[3];
		
		arr[0] = new Rect(1,1,3,3);
		arr[1] = new Circle(2,2,5);
		
		Shape l = new Line(1,1,3,3);
		Line l1 = new Line(1,2,3,4);
		l.draw();// 부모 메서드 먼저 호출 후, 자식 메서드 호출
		l1.draw();
		
		for(Shape current : arr) {
			System.out.println(current);
		}
	}
}

class Shape {
	private int x;
	private int y;
	
	public Shape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println();
	}
		
	@Override
	public String toString() {
		return "x1=" + x + ", y1=" + y;
	}
}

class Line extends Shape {
	private int x2;
	private int y2;
	
	public Line(int x, int y, int x2, int y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	@Override
	public void draw() {
		super.draw();
		System.out.println("선그리기");
	}

	@Override
	public String toString() {
		return super.toString() + ", x2=" + x2 + ", y2=" + y2;
	}
}

class Rect extends Shape {
	
	private int width;
	private int height;
	
	public Rect(int x, int y, int width, int height) {
		super(x, y);
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
	public void draw() {
		super.draw();
	}
	
	@Override
	public String toString() {
		return super.toString() + ", width=" + width + ", height=" + height;
	}	
}

class Circle extends Shape {
	
	private int radius;

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		super.draw();
	}
	
	@Override
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}
	
//	is a 관계
//		고양이 is a 동물
//	has a 관계(포함 관계)
//		자동차 has a 엔진
//		class 자동차{
//			엔진 e;
//		}
}