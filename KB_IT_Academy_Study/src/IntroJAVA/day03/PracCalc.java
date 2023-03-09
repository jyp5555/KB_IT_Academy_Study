package IntroJAVA.day03;

public class PracCalc {

	public static void main(String[] args) {
		Calc calc = new Calc();//생성자 호출
		
		int answer1 = calc.plus(5,5);
		int answer2 = calc.minus(3,5);
		double answer3 = calc.divide(3,5);
		
		System.out.println(answer1+"");
		System.out.println(answer2+"");
		System.out.println(answer3+"");
	}
}
