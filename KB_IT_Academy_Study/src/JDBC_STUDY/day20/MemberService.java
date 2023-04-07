package JDBC_STUDY.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberService {
	
	MemberDao memberDao = new MemberDao();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void print() throws IOException {
		
		System.out.print("아이디: ");
		String id = br.readLine().strip();
		
		try {
			System.out.println(memberDao.getOne(new MemberDto(id, "", "", "")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void printAll() {
		try {
			for(MemberDto member : memberDao.getAll()) {
				System.out.print(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createMember() throws IOException {
		
		System.out.print("아이디: ");
		String id = br.readLine().strip();
		System.out.print("비번: ");
		String pwd = br.readLine().strip();
		System.out.print("이름: ");
		String name = br.readLine().strip();
		System.out.print("소개: ");
		String intro = br.readLine().strip();
		
		try {
			memberDao.post(new MemberDto(id,pwd, name, intro));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		printAll();
	}
	
	public void updateMember() throws IOException {
	
		System.out.print("아이디: ");
		String id = br.readLine().strip();
		System.out.print("비번: ");
		String pwd = br.readLine().strip();
		System.out.print("이름: ");
		String name = br.readLine().strip();
		System.out.print("소개: ");
		String intro = br.readLine().strip();
		
		try {
			memberDao.put(new MemberDto(id,pwd, name, intro));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		printAll();
	}
	
	public void deleteMember() throws IOException {
		
		System.out.print("아이디: ");
		String id = br.readLine().strip();
		
		try {
			memberDao.deleteOne(new MemberDto(id, "", "", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		printAll();
	}
}
