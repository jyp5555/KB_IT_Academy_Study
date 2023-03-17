package JavaAlgorithm.day11;

import java.util.ArrayList;

public class ExamArrayList {

	public static void main(String[] args) {
//		Wrapper클래스 기본자료형을 객체화
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(100);
//		100 -> int, .add(Integer e) 서로 안맞지만, int ->Integer boxing / Integer ->int  unboxing
//		String 은 자동 X
		
		arr.add(200);
		arr.set(0, 300);
		System.out.println("저장개수 = "+arr.size());
		System.out.println(arr.get(0));
	}
}
