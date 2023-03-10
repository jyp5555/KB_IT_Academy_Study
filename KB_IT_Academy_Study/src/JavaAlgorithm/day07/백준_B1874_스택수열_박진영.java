package JavaAlgorithm.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_B1874_스택수열_박진영 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> numArr = new ArrayList<>();
		Stack<Integer> numStack = new Stack<>();
		Stack<Integer> tempSave = new Stack<>();
		Stack<Integer> result = new Stack<>();
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			numArr.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = n; i >0 ; i--) {numStack.push(i);}
		
		for(int i = 0;i < n;i++) {
			if(numArr.get(i) > numStack.get(n-i-1)) {
				tempSave.push(numArr.get(i));
			}else if(numArr.get(i) < numStack.get(n-i-1)) {
				
			}
		}
		
		
	}
}
