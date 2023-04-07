package IntroJAVA.day17;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exam예외4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = load_file();//실패시 실패 원인을 알 수 없음...
		System.out.println(fr);

		FileReader fr2 = null;
		try {
			fr2 = load_file2();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 열기 실패" + e.getMessage());
		}//실패시 실패 원인을 알 수 있음!!
		
		System.out.println(fr2);
		/*
		 * 보통 자원 접근 시 throws!
		 */
	}
	
	private static FileReader load_file() {
		FileReader fr = null;
		try {
			fr = new FileReader("hello.txt");
		}catch(FileNotFoundException e) {
			System.out.println("파일열기 실패");
		}
		return fr;
	}
	
	private static FileReader load_file2() throws FileNotFoundException {
		FileReader fr = null;
		fr = new FileReader("hello.txt");
		return fr;
	}

}
