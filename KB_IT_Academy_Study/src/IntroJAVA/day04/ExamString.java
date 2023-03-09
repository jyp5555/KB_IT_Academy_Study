package IntroJAVA.day04;

public class ExamString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";//String만 =""로 만들면, 상수풀에 abc를 만들고 주소를 던져줌
		String s2 = "abc";
		String s3 = new String("abc");//new는 힙공간에 새로 만드는 거라 s3, s4는 서로 다른 객체임.
		String s4 = new String("abc");
		
		System.out.println(s1 == s2);//주소값 비교
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		System.out.println(s1.equals(s3));//내용 비교
		
		/**
		 * ++++++++++++++++++++++++++
		 * +class	+힙		+스택		+
		 * +		+		+		+
		 * +		+		+		+
		 * +		+		+		+
		 * +		+		+		+
		 * +		+		+		+
		 * +		+		+		+
		 * ++++++++++++++++++++++++++
		 */
		
		/**
		 * String Class는 Immutable 객체 내부 값 변경 X
		 * 
		 * 즉 
		 * String s1 = "abc";
		 * String s2 = "abc";
		 * s1+=s2;
		 * 해도 s1 새로운 문자열을 만들어서 붙이는 거임
		 */
		String test = "abc";
		String test2 = "abcabc";
		System.out.println(test.hashCode());
		System.out.println("abc".hashCode());
		System.out.println(test == "abc");
		System.out.println(test == test2);
//		test = test + "abc";
		System.out.println(test.concat("abc"));
		System.out.println(test = test.concat("abc"));
		System.out.println(test);
		System.out.println(test.hashCode());
		System.out.println("abcabc".hashCode());
		System.out.println(test == test2);
	}

}
