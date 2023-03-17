package JavaAlgorithm.day12;

import java.util.Arrays;

public class 백준_B9663_NQueen_박진영 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[4][4];
		System.out.println(Arrays.deepToString(visited));
//		Arrays.fill(visited[0], true);
		Arrays.fill(visited,0,1,true);
		System.out.println(Arrays.deepToString(visited));

	}
}
