package JavaAlgorithm.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 백준_B17608_막대기_박진영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stack = new int[n];

		for(int i = 0; i < n; i++) {
			stack[i] = sc.nextInt();
		}
		
		int max = 0;
		int ans = 0;
		for(int i = stack.length-1;i>=0;i--) {
			if(stack[i]>max) {
				max = stack[i];
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
