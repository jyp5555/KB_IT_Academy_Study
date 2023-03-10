package JavaAlgorithm.day07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_B1158_요세푸스_박진영 {

	public static void main(String[] args) {
		Queue<Integer> people = new LinkedList<>();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 1; i<n+1;i++) {
			people.add(i);
		}
		
		System.out.print("<");
		while(people.size() > 1) {
			for(int i = 1;i < m;i++) {
				people.add(people.poll());
			}
			
			System.out.printf("%d, ", people.poll());
		}
		System.out.printf("%d>\n",people.poll());
	}

}
