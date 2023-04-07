package IntroJAVA.day17;

public class ShapeNotFoundException extends Exception {
	private int x1;
	private int y1;

	public ShapeNotFoundException(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "도형없음: x1 = "+x1+", y1 = "+y1;
	}
}


/*
 * 반드시 처리 -> Exception상속
 * 반드시 처리는 X -> RuntimeException상속
 */