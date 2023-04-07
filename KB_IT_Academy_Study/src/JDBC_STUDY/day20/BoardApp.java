package JDBC_STUDY.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardApp {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. 회원가입 2. 글쓰기 3. 글 조회 4. 글 작성자 전체조회 5.전체 회원 조회 6. 회원 탈퇴");
		System.out.print("메뉴를 입력하세요 > ");
		int menu = Integer.parseInt(br.readLine().strip());
		
		switch (menu) {
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
	}
	
	
}
