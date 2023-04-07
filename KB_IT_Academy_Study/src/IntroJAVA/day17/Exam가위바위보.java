package IntroJAVA.day17;

import java.util.Random;

public class Exam가위바위보 {

	public static void main(String[] args) {
		Random r = new java.util.Random();
		int rnd = r.nextInt(3);
		System.out.println(rnd);
		String[] 가위바위보 = {"가위","바위","보"};
		System.out.println(가위바위보[rnd]);
	}

}
