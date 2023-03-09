package JavaAlgorithm.day06;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_B11659_구간합구하기4_박진영 {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        
        int[] numArr = new int[N+1];
        int i = 0;
        for(String num : sc.nextLine().split(" ")) {
        	numArr[i+1] = numArr[i] + Integer.parseInt(num);
        	i++;
        }
        
        for (int num : numArr) {
        	System.out.print(num + "\t");
        }
        
        for (int k = 0; k < M; k++) {
            int l = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(numArr[j] - numArr[l - 1]);
        } 
	}
}


