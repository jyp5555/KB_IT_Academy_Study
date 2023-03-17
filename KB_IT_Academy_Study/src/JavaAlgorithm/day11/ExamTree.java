package JavaAlgorithm.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExamTree {
	static boolean[] visited;
	static ArrayList<HashSet<Integer>> nodeArr;
	static Stack<Integer> visitedNode;
	public static void main(String[] args) throws IOException {
		
		nodeArr = new ArrayList<>();
		visitedNode = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		for(int i = 0 ; i < N ; i++ ) {
			HashSet<Integer> hashSet = new HashSet<>();
			nodeArr.add(hashSet);
		}
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int node1  = Integer.parseInt(st.nextToken());
			int node2  = Integer.parseInt(st.nextToken());
			HashSet hashSet = nodeArr.get(node1-1);
			hashSet.add(node2);
			nodeArr.set(node1-1, hashSet);
			hashSet = nodeArr.get(node2-1);
			hashSet.add(node1);
			nodeArr.set(node2-1, hashSet);
		}
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.println(nodeArr.toString());
		System.out.println(count);
	}

	private static void DFS(int i) {
		if(visited[i]) return;
		visited[i] = true;
		for(int k : nodeArr.get(i)) {
			if(!visited[k-1]) {
				DFS(k-1);
			}
		}
	}

}
