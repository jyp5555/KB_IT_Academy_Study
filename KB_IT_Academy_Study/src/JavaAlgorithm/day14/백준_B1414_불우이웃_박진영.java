package JavaAlgorithm.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class 백준_B1414_불우이웃_박진영 {
	//사용할 랜선길이 -> 최소로 사용하고 나머지 기부
	//나머지가 최대가 되게 하자!

	
	static PriorityQueue<Node> queue;
	static int[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<>();
		
		v = new int[N+1];
		for(int i = 1 ; i <= N ;i++) {
			v[i] = i;
		}
		int allLAN = 0;
		int temp1 = 0;
		for(int i = 0 ; i < N ; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0 ; j < N ; j++) {
				int a = str[j].charAt(0);
				
				if(a==48) {temp1 = 0; continue;}
				else {					
					if(a >= 97) {temp1 = a-97 + 1;}
					else {temp1= a-65+27;}
					allLAN += temp1;
					if(i==j) continue;
					queue.add(new Node(i+1, j+1, temp1));
				}
				
			}
		}
		
		int result = 0;
		
		int k = 0;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(find(now.s) != find(now.e)) {
				union(now.s,now.e);
				result += now.v;
				k++;
			}			
		}
		
		
		if(k == N-1) System.out.println(allLAN-result);
		else System.out.println(-1);
	}
	private static void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i != j) v[j] = i;
		
	}
	private static int find(int i) {
		if(i == v[i]) return i;
		return find(v[i]);
	}

}

class Node implements Comparable<Node>{
	int s;
	int e;
	int v;

	public Node(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.v - o.v;
	}
}