package day04;

public class ExamStringBuilder {

	public static void main(String[] args) {
		
		String s = "0123456789";
		String s1 = s;
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < 10000 ; i++) {
			s1 += s;
		}
		long end = System.currentTimeMillis();
		System.out.println("String: "+(end-start));//150
		
		/**
		 * StringBuffer와 StringBuilder의 차이점
		 * StringBuffer -> 한 번에 하나의 일만, blocking!
		 * StringBuilder -> 자원에 대한 잠금 기능 X, 멀티스레드 상에서는 데이터가 꼬일 확률...
		 */
		
		StringBuffer stringBuffer = new StringBuffer("0123456789");
		long start3 = System.currentTimeMillis();
		for(int i = 0 ; i < 10000 ; i++) {
			stringBuffer.append(s);
		}
		long end3 = System.currentTimeMillis();
		System.out.println("StringBuilder: " + (end3-start3));//1
		
		StringBuilder stringBuilder = new StringBuilder("0123456789");
		long start2 = System.currentTimeMillis();
		for(int i = 0 ; i < 10000 ; i++) {
			stringBuilder.append(s);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("StringBuilder: " + (end2-start2));//0
	}
}
