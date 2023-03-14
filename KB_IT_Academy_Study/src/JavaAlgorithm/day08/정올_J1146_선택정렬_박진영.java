package JavaAlgorithm.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_J1146_선택정렬_박진영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		selectionSort(nums);
	}

	private static void selectionSort(int[] nums) {
		
		for(int i = 0 ; i < nums.length-1 ; i++) {
			int min = 101;
			int minIndex = 0;
			for(int j = i; j < nums.length ; j++) {
				if(nums[j] < min) {
					min = nums[j];
					minIndex = j;
				}
			}
			nums[minIndex] = nums[i];
			nums[i] = min;
			
			for(int k = 0; k< nums.length-1 ; k++) {
				System.out.printf("%d ",nums[k]);
			}
			System.out.printf("%d\n",nums[nums.length-1]);
		}
	}

}
