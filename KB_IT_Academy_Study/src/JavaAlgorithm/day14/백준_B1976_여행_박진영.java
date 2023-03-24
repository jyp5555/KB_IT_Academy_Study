package JavaAlgorithm.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_B1976_여행_박진영 {
	
	static int[][] adjMatrix;
	static int[] node;
	static ArrayList<Integer> plan;
	public static void main(String[] args) throws IOException {
	
		/*
		 * 1번째 줄 도시수
		 * 2번째 줄 여행계획 도시 수
		 * 도시수만큼의 줄에서 인접행렬 주어짐...
		 * 마지막줄 여행계획
		 * 분할된 그래프에서 나온 도시들끼리는 안됨...
		 * 
		 * union과 find
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		node = new int[N+1];
		int M = Integer.parseInt(br.readLine());
		plan = new ArrayList<>();
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			node[i] = i;
		}
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			plan.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1 ; i <= N ;i++) {
			for (int j = i+1 ; j<=N ; j++){
				if(adjMatrix[i][j] == 1) union(i,j);
			}
		}
		
		int k = find(plan.get(0));
		for(int i : plan) {
			if(k != find(i)) {
				System.out.println("NO"); return;
			}
		}
		System.out.println("YES");
		
	}
	private static void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		node[i] = j;
	}
	
	private static int find(int j) {
		if(j == node[j]) return j;
		return find(node[j]);
	}
	
}
