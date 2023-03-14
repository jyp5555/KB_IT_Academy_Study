package JavaAlgorithm.day08;

import java.util.HashMap;

public class ExamHashMap {

	public static void main(String[] args) {
		HashMap<String, Integer> scores = new HashMap<>();
		scores.put("",1);
		scores.put("123",1);
		System.out.println(scores.get("2"));
		System.out.println(scores.getOrDefault("3", 0));// 없으면 기본값 0
//		수정 put
//		삭제 remove, 삭제값 반환
	}
}
