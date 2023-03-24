package JavaAlgorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_B2178_미로_박진영 {//중요 BFS, DFS
	
	static int[][] maze;
	static boolean[][] visited;
	static int N,M;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		ans = new ArrayList<>();

		for(int i = 0; i < N ; i++) {
			String[] temp = br.readLine().split("");
			
			for(int j = 0 ; j < M ; j++) {
				maze[i+1][j+1] = Integer.parseInt(temp[j]);
			}
		}
		BFS(1,1);

		System.out.println(maze[N][M]);
	}
	private static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x,y});
		visited[x][y] = true;
		
		int[] dx = {-1,+1,0,0};
		int[] dy = {0,0,-1,+1};
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i<4 ;i++) {
				if(!visited[now[0]+dx[i]][now[1]+dy[i]] && maze[now[0]+dx[i]][now[1]+dy[i]] != 0) {
					visited[now[0]+dx[i]][now[1]+dy[i]] = true;
					maze[now[0]+dx[i]][now[1]+dy[i]] = maze[now[0]][now[1]] +1;
					queue.add(new int[] {now[0]+dx[i],now[1]+dy[i]});
				}
			}
		}
		
	}

}
