package JavaAlgorithm.day07;

import java.util.Stack;

public class ExamStack2 {

	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<>();
		st.push(100);
		st.push(200);
		st.push(300);
		st.push(400);
		st.push(500);

		while(!st.isEmpty()) {
			System.out.printf("마지막 원소: %d, 스택: %s\n",st.pop(),st.toString()); 
		}
	}

}
