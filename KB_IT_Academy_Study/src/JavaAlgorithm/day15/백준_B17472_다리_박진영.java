package JavaAlgorithm.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_B17472_다리_박진영 {
	static int[][] matrix;
	static int[][] matrix2;
	static int[] n;
	static boolean[][] visited;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		matrix = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1 ; j <= M ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());			
			}
		}
		
		int landName = 1;
		for(int i = 1 ; i <= N ; i++) {
			for (int j = 1; j <= M ; j++) {
				if(matrix[i][j] >= 1) {
					if(matrix[i-1][j] >= 1) {
						matrix[i][j] = matrix[i-1][j];
					}else if(matrix[i][j-1] >= 1){
						matrix[i][j] = matrix[i][j-1];
					}else {
						matrix[i][j] = landName++;
					}
				}
			}
		}
		 n = new int[landName];
		 for(int i = 1; i < landName ; i++) n[i] = i;
		
		// TODO: path 리스트
		for(int i = 1 ; i <= N ; i++) {
			for (int j = 1; j <= M ; j++) {
				visited = new boolean[N+2][M+2];
				if(matrix[i][j] >=1 ) {
					visited[i][j] = true;
					
				}
			}
		}
		 
		// TODO: union-find 최소 스패닝 트리
		
		
		
		for(int[] k : matrix) {
			System.out.println(Arrays.toString(k));
			
		}
	}
}

class Land {
	
	int startLand;
	int endLand;
	int path = 0;
	
	public Land(int landName) {
		super();
//		this.landName = landName;
	}
}


class Bridge implements Comparable<Bridge>{
	int startLandName;
	int endLandName;
	int length;
	

	public int compareTo(Bridge o) {
		return this.length - o.length;
	}
}
