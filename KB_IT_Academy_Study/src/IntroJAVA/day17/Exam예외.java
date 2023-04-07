package IntroJAVA.day17;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exam예외 {
/*
 * Exception: SW처리 가능한 오류
 * Error: SW처리 불가능한 오류
 * try catch 메서드 내부 처리, throws 외부로! 선언
 * 
 * Checked Exception 반드시 처리해야하는 예외 대부분이 해당
 * Unchecked Exception 처리 코드 없어도 컴파일 오류X, 런타임Exception과 그 자손들...(Null, IndexOut, ArrayIndex)
 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		한꺼번에 정상적으로 실행해야할 코드 묶음: 트랜잭션!!!
		new FileReader("hello.txt"); //src폴더 밖에 있어야함 실패시 메서드 종료
		System.out.println("파일 열기 성공");
	}

}
