package JavaAlgorithm.day07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_B2164_카드2_박진영 {

	public static void main(String[] args) {
		Queue<Integer> cards = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1;i<n+1;i++) {
			cards.add(i);
		}
		while(cards.size() > 1) {
			cards.poll();
			cards.add(cards.poll());
		}
		System.out.println(cards.poll());
	}
}
