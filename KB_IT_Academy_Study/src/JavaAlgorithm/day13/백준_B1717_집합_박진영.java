package JavaAlgorithm.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_B1717_집합_박진영 {
	static int[] n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		n = new int[N+1];
		for(int i = 1 ; i < N+1 ; i++) {
			n[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int 연산 = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(연산 == 1) {
				sb.append(isSame(a,b) ? "YES" : "NO");
				sb.append("\n");
				
			}else {
				union(a,b);
			}
			
			
		}
		System.out.println(sb.toString());
	}

	private static void union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if(a1 != b1) {
			if(a1 < b1)	n[b1] = a1;
			else n[a1] = b1;
		}
	}

	private static int find(int a) {
		if(a == n[a]) return a;
		return find(n[a]);
		
	}
	private static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}

}
