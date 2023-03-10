package JavaAlgorithm.day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ExamQueue {

	public static void main(String[] args) {
//		FIFO
		LinkedList<Integer> lnkli = new LinkedList<>();
		/**
		 * void java.util.AbstractSequentialList.add(int index, E element)
		 * Overrides: add(...) in AbstractList
		 */
		lnkli.add(0,1);
		
		HashMap<Integer,ArrayList<Integer>> test = new HashMap<>();
		test.put(0, new ArrayList<Integer>());
		test.get(0).add(1);
		test.get(0).add(2);
		System.out.println(test.toString());
	}

}
