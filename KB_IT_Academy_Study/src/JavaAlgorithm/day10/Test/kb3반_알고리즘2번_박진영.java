package JavaAlgorithm.day10.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb3반_알고리즘2번_박진영 {
	
	static int[] combinationResult;
	static int max,Sum;
	static ArrayList<Integer> combinaitionResultList = new ArrayList<>(); 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Sum = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		combinationResult = new int[3];
		getCombination4(0,nums,0);
		
		System.out.println(combinaitionResultList.get(combinaitionResultList.size()-1));
	}
	
	static void getCombination4(int cnt, int[] arr, int j) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i<combinationResult.length;i++) {
				sum+=combinationResult[i];
			}
			if (max< sum && Sum >sum) combinaitionResultList.add(sum);
            return;
        }
        for (int i = j; i < arr.length; i++) {
        	combinationResult[cnt] = arr[i];
            getCombination4(cnt + 1, arr,i+1);
        }
	}

}
