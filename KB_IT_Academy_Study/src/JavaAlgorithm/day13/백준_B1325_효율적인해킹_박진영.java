package JavaAlgorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_B1325_효율적인해킹_박진영 {
	static int[][] answer;
	static ArrayList<Integer>[] hack;
	static boolean arrive;
	static boolean[] visited;
	static int c, max;
	//BFS로 풀어보자 p164,165

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		visited[0] = true;
		hack = new ArrayList[N+1];
		answer = new int[N+1][2];
		
		for(int i = 0 ; i < N+1 ; i++) {
			hack[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			hack[n1].add(n2);
		}
		
		for (int i = 1; i < N+1; i++) {
			visited = new boolean[N+1]; // 초기화
			visited[i] = true;
			answer[i][1]++;
			BFS(i);
		}
		
		 
		Arrays.sort(answer, new Comparator<int[]> () {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o2[1] == o1[1]) return o1[0] - o2[0];
				return o2[1] - o1[1];
			}
			
		});;
		
		max = answer[0][1];
		
		StringBuilder result = new StringBuilder();
		for(int j = 0 ; j < N+1 ; j++ ) {
			if(max == answer[j][1]) {
				result.append(answer[j][0]);
				result.append(" ");
			}else {
				break;
			}
		}
		System.out.println(result.toString());
	}
	private static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visited[i] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int j : hack[now]) {
				if(!visited[j]) {
					visited[j] = true;
					answer[j][0] = j;
					answer[j][1]++;
					queue.add(j);
				}
			}
		}
	}
	
}


