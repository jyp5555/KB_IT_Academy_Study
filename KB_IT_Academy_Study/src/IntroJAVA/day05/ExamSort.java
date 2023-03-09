package IntroJAVA.day05;

import java.util.Arrays;

public class ExamSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[3];
		arr[0] = 5;
		arr[1] = 3;
		arr[2] = 6;
		
		System.out.println(arr[0] +""+ arr[1] + arr[2]);
		Arrays.sort(arr);		
		System.out.println(arr[0] +""+ arr[1] + arr[2]);
	}
}
