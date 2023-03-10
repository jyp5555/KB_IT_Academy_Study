package JavaAlgorithm.day07;

import java.util.Stack;

public class ExamStack {

	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<>();
		stack1.push(100);
		System.out.println(stack1.toString());
		stack1.pop();
		System.out.println(stack1.toString());
	}

}
