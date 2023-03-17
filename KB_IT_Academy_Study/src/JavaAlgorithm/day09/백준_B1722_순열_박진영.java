package JavaAlgorithm.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_B1722_순열_박진영 {
	
	static ArrayList<Boolean> visited = new ArrayList<>();
	static ArrayList<String> permutationResultList = new ArrayList<>();
	static int[] permutationResult;
	

	static ArrayList<String> answerList = new ArrayList<>();
	static int n,r;
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int targetNumber = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int menu = Integer.parseInt(st.nextToken());
		if(menu == 1) {
			n = targetNumber-1;
			permutationResult = new int[targetNumber];
			int 순서 = Integer.parseInt(st.nextToken());
			for(int i = 0 ;i < targetNumber;i++) {
				visited.add(false);
			}
			permute(0);
			String answer = permutationResultList.get(순서-1);
			
			System.out.println(answer);
		}else {
			
		}
		
	}

	private static void permute(int cnt) {
		if (cnt == n) {
			permutationResult[n] = visited.indexOf(false)+1;
			permutationResultList.add(Arrays.toString(permutationResult).toString());
			return;
		}
		for(int i = 0; i <= n ; i++) {
			if(!visited.get(i)) {
				visited.set(i, true);
				permutationResult[cnt] = i+1;
				permute(cnt+1);
				visited.set(i, false);
			}
		}
	}
}
