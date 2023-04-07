package IntroJAVA.day18;

import java.util.HashMap;

public class ExamMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("a",100);
		scoreMap.put("b",90);
		scoreMap.put("c",60);
		scoreMap.put("c",80);
		
		Integer k = scoreMap.get("d");
		System.out.println(k);
		System.err.println(k);
		System.out.println(scoreMap.keySet());
		System.out.println(scoreMap);
	}

}
