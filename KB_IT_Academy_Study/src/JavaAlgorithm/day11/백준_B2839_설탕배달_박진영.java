package JavaAlgorithm.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 백준_B2839_설탕배달_박진영 {
	public static void main(String[] args) {
		int[] sugar = {5,3};
		int count = 0;
		int weight = new Scanner(System.in).nextInt();
		int maxCount = weight/3+1;
		ArrayList<Integer> xy = new ArrayList<>();
		for(int x = 0 ; x <= maxCount ; x++) {
			for(int y = 0 ; y <= maxCount-x ; y ++) {
				if((5*x+3*y) == weight) {
					xy.add(x+y);
				}	
			}
		}
		if(xy.size() == 0) {
			System.out.println(-1);
		}else {
			Object[] ans = xy.toArray();
			Arrays.sort(ans);
			System.out.println(ans[0]);
		}
	}
}
