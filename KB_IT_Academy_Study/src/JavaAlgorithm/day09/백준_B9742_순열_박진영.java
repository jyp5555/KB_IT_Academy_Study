package JavaAlgorithm.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_B9742_순열_박진영 {
	static ArrayList<String> ans = new ArrayList<String>();
	static char[] arr1;
	static int n1, m;
	static ArrayList<Boolean> visited = new ArrayList<Boolean>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String temp = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		
		char[] temp2 = new char[temp.length()];
		arr1 = new char[temp.length()];
		n1 = temp.length()-1;
		m = temp.length()-1;
		for(int i =0 ;i<temp.length()+1;i++) {
			visited.add(false);
		}
		try {
			for (int i = 0; i<temp.length();i++) {
				temp2[i] = temp.charAt(i);
			}
		}catch(NumberFormatException e) {
			temp2 = temp.toCharArray();
		}
		
		getPermut(0,temp2);
		String str;
		try {
			str = ans.get(n-1);
		}catch(Exception e) {
			str = "No permutation";
		}
		
		System.out.println(temp+" "+n + " = "+ str );
	}
	
	static void getPermut(int cnt, char[] arr){
		ArrayList<String> temp = new ArrayList<String>();
		for(char c : arr) temp.add(""+c);
		if (cnt == m) {
			arr1[cnt] = temp.get(visited.indexOf(false)).toCharArray()[0];
			String str = String.valueOf(arr1);
			ans.add(str);
			return;
		}
		
		for (int i = 0; i <= n1; i++) {
            if (!visited.get(i)) {
                visited.set(i, true);
                arr1[cnt] = temp.get(i).toCharArray()[0];
                getPermut(cnt + 1, arr);
                visited.set(i, false); // 다시 방문을 풀어줘야지만 한 번 재귀 끝나고 다시 갈 수 있음
            }
        }
	}
}
