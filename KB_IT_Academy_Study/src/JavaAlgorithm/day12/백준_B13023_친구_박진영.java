package JavaAlgorithm.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 백준_B13023_친구_박진영 {
	static int answer = 0;
	static ArrayList<Integer>[] relationMap;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NM =  Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		relationMap = new ArrayList[NM[0]];
		visited = new boolean[NM[0]];
		
		System.out.println(Arrays.deepToString(relationMap));
		for(int i = 0 ; i < NM[1] ; i++) {
			int[] temp =  Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(relationMap[temp[0]] == null && relationMap[temp[1]] == null) {
				relationMap[temp[0]] = new ArrayList<>(); 
				relationMap[temp[1]] = new ArrayList<>();
				relationMap[temp[0]].add(temp[1]);
				relationMap[temp[1]].add(temp[0]);
			}else if(relationMap[temp[0]] == null && relationMap[temp[1]] != null){
				relationMap[temp[0]] = new ArrayList<>(); 
				relationMap[temp[0]].add(temp[1]);
				relationMap[temp[1]].add(temp[0]);
			}else if(relationMap[temp[0]] != null && relationMap[temp[1]] == null) {
				relationMap[temp[1]] = new ArrayList<>(); 
				relationMap[temp[0]].add(temp[1]);
				relationMap[temp[1]].add(temp[0]);
			}else {
				relationMap[temp[0]].add(temp[1]);
				relationMap[temp[1]].add(temp[0]);
			}
		}
				
		DFS(1,0);
		System.out.println(Arrays.deepToString(relationMap));
		System.out.println(answer);

	}
	private static void DFS(int count, int now) {
		// TODO Auto-generated method stub
		if(count == 5) {
			answer = 1;
			return;
		}
		visited[now] = true;
		for(int i : relationMap[now]) {
			if(!visited[i]) {
				DFS(count+1, i);
			}
		}
		visited[now] = false;
	}
}
