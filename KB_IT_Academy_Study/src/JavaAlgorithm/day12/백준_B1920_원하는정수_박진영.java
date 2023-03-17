package JavaAlgorithm.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class 백준_B1920_원하는정수_박진영 {
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().strip());
		int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int M = Integer.parseInt(br.readLine().strip());
		int[] target = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		answer = new int[M];
		
		Arrays.sort(nums);
		for(int i= 0; i<M;i++) {
			binarySearch(nums,0,nums.length-1,target[i], i);
		}
		for(int i= 0; i<M;i++) {
			System.out.println(answer[i]);
		}
	}

	private static void binarySearch(int[] nums, int start, int end, int i, int index) {
		
		int center = (start+end) /2;
		
		if(nums[center] == i) {
			answer[index] = 1;
			return;
		}
		else if(start-end >= 0) {
			return;
		}
		else if(nums[center] > i) {
			binarySearch(nums,start,center,i,index);
		}
		else {
			binarySearch(nums,center+1,end,i, index);
		}
	}
}
