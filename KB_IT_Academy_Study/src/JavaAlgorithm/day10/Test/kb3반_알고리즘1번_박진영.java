package JavaAlgorithm.day10.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb3반_알고리즘1번_박진영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		for(int i = 0; i < N ; i++) {
			nums[i] = Integer.parseInt(br.readLine().strip());
		}
		
		selectionSort(nums);
	}

	private static void selectionSort(int[] nums) {
		
		for(int i = 0 ; i < nums.length-1 ; i++) {
			int max = 0;
			int maxIndex = 0;
			for(int j = i; j < nums.length ; j++) {//최솟값 구하기
				if(nums[j] > max) {
					max = nums[j];
					maxIndex = j;
				}
			}
			nums[maxIndex] = nums[i];
			nums[i] = max;
		}
		
		for(int k = 0; k< nums.length ; k++) {
			System.out.printf("%d\n",nums[k]);
		}
	}

}
