package JavaAlgorithm.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_B1197_최소신장트리_박진영 {
	static int[][] sev;
	static int[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		sev = new int[E][3];
		v = new int[V+1];
		for(int i = 1 ; i <= V ;i++) {
			v[i] = i;
		}
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			sev[i][0] = Integer.parseInt(st.nextToken());
			sev[i][1] = Integer.parseInt(st.nextToken());
			sev[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sev, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}			
		});
		
		int result = 0;
		int count = 0;
		for(int[] j : sev) {
			if(find(j[0]) != find(j[1])) {
				union(j[0],j[1]);
				result += j[2];
				count++;
				if(count == sev.length-1) break;
			}
			
		}
		
		System.out.println(result);
		
	}
	private static void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i != j) v[j-1] = i;
		
	}
	private static int find(int i) {
		if(i == v[i]) return i;
		return find(v[i]);
	}

}
