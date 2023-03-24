package JavaAlgorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_B1167_트리지름_박진영 {
	
	static boolean visited;
	static int N,M;
	static ArrayList<Node>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		adjList[0] = new ArrayList<>();
		
		for(int i = 1; i <=N ; i++){
			String[] temp = br.readLine().split(" ");
			adjList[i] = new ArrayList<>();
			for(int j = 0 ; j < temp.length ; j++){
				
			}
		}
		System.out.println(adjList.toString());
	}
}
class Node{
	int node;
	int len;
	
}
