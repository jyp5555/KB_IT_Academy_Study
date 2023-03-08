package day05;

public class ExamMath {

	public static void main(String[] args) {
		double r = Math.random();
		System.out.println(r);;
		r*=100;
		System.out.println(r);
		r = Math.floor(r);
		System.out.println(r);
		r += 1;
		System.out.println(r);
	}
}
