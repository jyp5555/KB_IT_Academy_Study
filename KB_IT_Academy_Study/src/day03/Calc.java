package day03;

public class Calc {

	/**
	 * 생성자는 클래스 명과 동일, 리턴 타입 없음
	 */
	public Calc() {}//생성자 없으면 컴파일러가 일단 기본 생성자를 띄움
	
	/**
	 * 더하기 함수
	 * @param i
	 * @param j
	 * @return i+j
	 */
	public int plus(int i, int j) {return i+j;}//i,j는 로컬 변수이기에 스택에 만들어졌다가 사라짐
	
	/** 
	 * 오버라이딩: 메서드 이름, 파라미터,리턴 =, 지정자 >=
	 * 
	 * 자바 객체지향 .java -> .class -> 한 줄씩
	 * 
	 */
	
	/**
	 * int plus (int i, int j) 메서드 오버로딩, 메서드이름만 같음
	 */
	public double plus(double x, double y) {return x+y;}
	public double plus(double x, int y) {return x+y;}
	public double plus(int x, double y) {return x+y;}


	/**
	 * 빼기 함수
	 * @param i
	 * @param j
	 * @return i-j
	 */
	public int minus(int i, int j) {return i-j;}

	public double divide(int i, int j) {
		return (double)i/j;//return 1.0*i/j;
	}
}
