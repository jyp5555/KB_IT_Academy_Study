package JavaAlgorithm.day08;

public class ExamRecursion {

	public static void main(String[] args) {
		
		int ans = factorial(5);
		System.out.println(ans);
	}

	
	
	private static int factorial(int i) {
		int ans = 0;
		/**
		 * 재귀호출, 종료조건 검사
		 */
		if(i > 0) {
			return i * factorial(i-1);
		}else {
			return 1;
		}
		/**
		 * if(i == 0) ans = 1; Stack Over Flow error!! -> return 1;
		 * return i * factorial(i-1); 
		 */
	}
}
