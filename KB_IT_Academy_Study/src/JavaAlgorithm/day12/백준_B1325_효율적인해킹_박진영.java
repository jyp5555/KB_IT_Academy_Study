package JavaAlgorithm.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class 백준_B1325_효율적인해킹_박진영 {
	static HashMap<Integer, Integer> answer;
	static HashMap<Integer, ArrayList<Integer>> hack;
	static boolean arrive;
	static boolean[] visited;
	static int c, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		visited[0] = true;
		hack = new HashMap<>();
		answer = new HashMap<>();
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(hack.get(n2) == null) {
				ArrayList<Integer> trust = new ArrayList<Integer>();
				trust.add(n1);
				hack.put(n2, trust);
			}
			else {
				hack.get(n2).add(n1);
			}
		}
		
		System.out.println(hack.toString());
		for(int i = 1; i<=N ; i++) {
			c = 0; 
			DFS(i,0);
			answer.put(i,c);
			if(arrive) continue;
		}
		
		max = 0; ArrayList<Integer> ans = new ArrayList<>(); ArrayList<Integer> val  = (ArrayList<Integer>) answer.values();
		for(int i = 0; i<val.size();i++) {
			
			if(max < val.get(i)) {
				max = val.get(i);
			}
		}
		
		for(int i = 0 ; i < val.size() ;i++) {
			if(max == val.get(i)) ans.add(i+1);
		}
		
		StringBuilder finalAns = new StringBuilder();
		for(int i : ans) {
			finalAns.append(i);
			finalAns.append(" ");
		}
		System.out.println(finalAns);
	}

	private static void DFS(int now,int count) {
		if(hack.get(now) == null) {
			arrive = true; 
			c = count;
			return;
		}
		visited[now] = true;
		for(int i : hack.get(now)) {
			if(!visited[i]) {
				DFS(i,count+1);
			}			
		}
		visited[now] = false;
	}
}
