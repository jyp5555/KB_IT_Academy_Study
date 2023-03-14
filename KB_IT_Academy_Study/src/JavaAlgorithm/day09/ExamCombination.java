package JavaAlgorithm.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExamCombination {
	private static int n1, m;
	private static int[] arr1; // 원소를 저장할 배
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int r = sc.nextInt();
//		
////		nCr = n-1Cr-1+n-1Cr
//		if(n >= r) {
//			long time1 = System.currentTimeMillis();
//			System.out.println(getCombination(n,r));
//			long time2 = System.currentTimeMillis();
//			System.out.println(getCombination2(n,r));
//			long time3 = System.currentTimeMillis();
//			System.out.println(getCombination3(n,r)); // 큰수를 집어넣으면, Exception in thread "main" java.lang.ArithmeticException: / by zero
//			long time4 = System.currentTimeMillis();
//			System.out.println( time2-time1 );
//			System.out.println( time3 -time2 );
//			System.out.println( time4 -time3 );
//
//
//		}
		arr1 = new int[2];
		n1 = 3;
		m = 2;
		getCombination4(0,new int[] {1,2,3},0);
	}

	private static int getCombination(int n, int r) {
		int[][] comb = new int[n+1][n+1];
		for(int i = 0 ; i <= n ; i++) {
			comb[i][0] = 1;
			comb[i][1] = i;
			for(int j = 2;j <= n-1; j++) {
				if(i == 0) break;
				comb[i][j] = comb[i-1][j] + comb[i-1][j-1];
			}
			comb[i][i] = 1;
		}
		/**
		 * [1][0][0][0][0][0]
		 * [1][1][0][0][0][0]
		 * [1][2][1][0][0][0]
		 * [1][3][0][1][0][0]
		 * [1][4][0][0][1][0]
		 * [1][5][0][0][0][1]
		 */
		return comb[n][r];	
	}
	
	private static int getCombination2(int n, int r) {
		
		if(n < 1 || r < 1 || n == r) return 1;
		else if(n > 1 && r == 1) return n;
		else {
			return getCombination2(n-1,r-1) + getCombination2(n-1,r);
		}
	}
	
	static long getCombination3(int n, int r){
		long[] factorialArr = new long[n+1];
		factorialArr[0] = 1;
		for(int i = 1; i <= n ;i++) {
			factorialArr[i] = i*factorialArr[i-1];
		}
		System.out.println(Arrays.toString(factorialArr) + " " + factorialArr[n]);
		return(factorialArr[n]/((long)factorialArr[n-r]*factorialArr[r]));
	}
	
	static void getCombination4(int cnt, int[] arr, int j) {
		if (cnt == m) {
            System.out.println(Arrays.toString(arr1));
            return;
        }
        for (int i = j; i < n1; i++) {
        	arr1[cnt] = arr[i];
            getCombination4(cnt + 1, arr,i+1);
        }
	}

}
