package JavaAlgorithm.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 백준_B2839_설탕배달_박진영2 {
	public static void main(String[] args) {
		int[] sugar = {5,3};
		
		int weight = new Scanner(System.in).nextInt();
		int count = 1667;
		for(int i = weight/3 +1 ; i >= 0 ; i--) {
			for(int j = weight/3 +1 - i ; j >= 0 ; j--) {
				if(5*i + 3*j == weight && count > i+j) count = i+j;
			}
		}
		
		if(count == 1667) count = -1;
		System.out.println(count);
	}
}
