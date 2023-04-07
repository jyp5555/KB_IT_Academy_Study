package IntroJAVA.day17;

import java.util.Arrays;

public class Exam예외3 {

	public static void main(String[] args) {
		int[] arr = {2,3,4};
		System.out.println("arr[3] = "+arr[3]);
		/*
		 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		 */
		System.out.println("ok");
		
		int[] arr1 = null;		
		System.out.println(arr1.length);
		/*
		 * Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "arr1" is null
		 */
	}
}
