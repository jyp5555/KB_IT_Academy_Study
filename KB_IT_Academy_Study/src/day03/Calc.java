package day03;

public class Calc {

	public Calc() {}

	/**
	 * 더하기 함수
	 * @param i
	 * @param j
	 * @return i+j
	 */
	public int plus(int i, int j) {return i+j;}//i,j는 로컬 변수이기에 스택에 만들어졌다가 사라짐

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
