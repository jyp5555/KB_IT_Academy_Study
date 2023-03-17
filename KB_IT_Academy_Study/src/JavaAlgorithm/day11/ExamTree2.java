package JavaAlgorithm.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExamTree2 {
	//using Stack, and directed Graph dfs
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> nodeArr;
	static Stack<Integer> visitedStack;
	static ArrayList<Integer> visitedArr;
	
	public static void main(String[] args) throws IOException {
		
		nodeArr = new ArrayList<>();
		visitedStack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		visitedArr = new ArrayList<>();
		
		//graph init
		for(int i = 0 ; i < N ; i++ ) {
			ArrayList<Integer> arr = new ArrayList<>();
			nodeArr.add(arr);
		}
		
		for(int i = 0 ; i < E ; i++) { 
			st = new StringTokenizer(br.readLine());
			int node1  = Integer.parseInt(st.nextToken());
			int node2  = Integer.parseInt(st.nextToken());
			ArrayList<Integer> arr = nodeArr.get(node1-1);
			arr.add(node2);
			nodeArr.set(node1-1, arr);
			if(i == 0) {
				visitedStack.push(node1);
			}
		}
		//graph init end
		
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i]) {
				DFSstack(i);
			}
		}
		
		System.out.println(nodeArr.toString());
		System.out.println(visitedArr.toString());
		System.out.println(visitedStack.toString());
		System.out.println(count);
	}

	private static void DFSstack(int i) {
		if(visited[i]) return;
		if(i==0) {
			int k = visitedStack.pop();
			visitedArr.add(k);
			visited[k-1] = true;
		}
		
		for(int j : nodeArr.get(i)) {
			visitedStack.push(j);
		}
		int k = visitedStack.pop();
		visitedArr.add(k);
		visited[k-1] = true;
		if(visitedStack.size() == 0) return;
		DFSstack(k-1);
	}

}
