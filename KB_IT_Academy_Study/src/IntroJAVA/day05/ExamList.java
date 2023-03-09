package IntroJAVA.day05;

import java.util.ArrayList;

public class ExamList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add("abc");
		al.add(1);
		System.out.println(al);
		System.out.println(al.getClass());
		String a = (String)al.get(0);//Type mismatch: cannot convert from Object to String
		System.out.println(al.get(0).getClass());
		System.out.println(al.get(1).getClass());
//		String b = (String)al.get(1);//class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
		
		ArrayList<StringBuilder> alsb = new ArrayList<>();//<> => Generic
		alsb.add(new StringBuilder("12"));
		System.out.println(alsb);
		StringBuilder sb = new StringBuilder("34");
		alsb.add(sb);
		System.out.println(alsb);

		alsb.remove(0);
		System.out.println(alsb);

//		alsb.remove("34");
		alsb.remove(sb);
		System.out.println(alsb);

	}
}
