package JavaAlgorithm.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 백준_B9742_순열_박진영 {
	static ArrayList<char[]> ans = new ArrayList<char[]>();
	static char[] arr1;
	static int n1, m;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String temp = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		
		char[] temp2 = new char[temp.length()];
		arr1 = new char[temp.length()];
		n1 = temp.length()-1;
		m = temp.length()-1;
		visited = new boolean[temp.length()+1];
		try {
			for (int i = 0; i<temp.length();i++) {
				temp2[i] = temp.charAt(i);
			}
		}catch(NumberFormatException e) {
			temp2 = temp.toCharArray();
		}
		
		getPermut(0,temp2);
		System.out.println(ans.toString());
	}
	
	static void getPermut(int cnt, char[] arr){
		
		if (cnt == m) {
			arr1[arr1.length-1] = arr[m];
			ans.add(arr1);
			return;
		}
		
		for (int i = 0; i <= n1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr1[cnt] = arr[i];
    			System.out.println(arr1);

                getPermut(cnt + 1, arr);
                visited[i] = false; // 다시 방문을 풀어줘야지만 한 번 재귀 끝나고 다시 갈 수 있음
            }
        }
	}
}
