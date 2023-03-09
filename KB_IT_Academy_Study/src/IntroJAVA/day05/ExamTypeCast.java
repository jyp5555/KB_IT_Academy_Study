package day05;

import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamTypeCast {

	public static void main(String[] args) {

		byte b = (byte)200;
		System.out.println(b+"");
		
//		boolean boo = (boolean)0;//Cannot cast from int to boolean
		boolean boo = Boolean.parseBoolean("0");
		System.out.println(boo);
		
		String s = "100";
//		String s = "hello";Exception in thread "main" java.lang.NumberFormatException: For input string: "hello"
		int i = Integer.parseInt(s);
		System.out.println(i);
		
		
		/**
		 * 기본 타입은 변수 자체에 답이 들어가 있으나, 참조 데이터 타입은 주소값이 들어간다! <-32bit
		 */
	}
		
}