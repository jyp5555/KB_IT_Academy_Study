package IntroJAVA.day17;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exam예외2 {
/*
 * Exception: SW처리 가능한 오류
 * Error: SW처리 불가능한 오류
 * try catch 메서드 내부 처리, throws 외부로! 선언 <-다형성 적용
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] arr = {1,3,5};
			/*
			 * 밖에서 arr[0] = 1;하면 컴파일 에러!
			 * 자바는 블록 단위로 코드 관리한다.
			 */
			System.out.println(arr[3]);
			new FileReader("hello.txt"); 
			System.out.println("파일 열기 성공"); 
			/*
			 * 발생한 예외 타입검사 자식 ...> 부모
			 */
		}catch(FileNotFoundException e) {
			System.out.println("파일 열기 실패"+ e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e2) {
			System.out.println("인덱스 없음"+ e2.getMessage());
		}catch(NullPointerException e3) {
			e3.printStackTrace();
		}finally {
			/*
			 * 예외 발생 상관없이 무조건 실행! catch문이나 try문에서 return을 만나도 실행됨, finally이후 구문들은 return구문 만나면 실행XX
			 */
		}
		System.out.println("프로그램 종료");
		
	}

}
