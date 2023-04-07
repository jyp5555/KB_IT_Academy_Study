package IntroJAVA.day18;

import java.util.ArrayList;
import java.util.Arrays;

public class RentalManager {
	
	ArrayList<Content> contents;

	public static void main(String[] args) {
		RentalManager rentalManager = new RentalManager();
		
		Book2 b1 = new Book2(1234, "해리포터1", 10000, false, "JKRolling", 300);
		Book2 b2 = new Book2(1235, "해리포터2", 10000, false, "JKRolling", 300);
		Video v1 = new Video(1236, "해리포터3", 5000, false, "알폰소쿠아론", 120);
		Video v2 = new Video(1237, "해리포터4", 5000, false, "마이크뉴얼", 120);
		
		try {
			rentalManager.add(b1);
		} catch (SameIdException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			rentalManager.add(b2);
		} catch (SameIdException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			rentalManager.add(v1);
		} catch (SameIdException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			rentalManager.add(v2);
		} catch (SameIdException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("총등록: "+rentalManager.getAllCount());
		System.out.println("도서등록: "+rentalManager.getBookCount());
		System.out.println("비디오등록: "+rentalManager.getVideoCount());
		
		try {
			rentalManager.findContentById(1234);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			rentalManager.findContentById(1236);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			rentalManager.findContentById(1134);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			rentalManager.rentContent(1134);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			rentalManager.rentContent(1234);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			rentalManager.rentContent(1236);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			rentalManager.rentContent(1234);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			rentalManager.findBookById(1236);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rentalManager.printAll();
	}

	public RentalManager() {
		this.contents = new ArrayList<>();
	}
	
	public void add(Content content) throws SameIdException {
		for(Content c : contents) {
			if(c.getId()==content.getId()) throw new SameIdException(c.getId());
		}
		contents.add(content);
	}
	
	public void add(Video video) throws SameIdException {
		add((Content)video);
	}
	
	public void add(Book2 book) throws SameIdException {
		add((Content)book);
	}
	
	public int getAllCount() {
		return contents.size();
	}
	
	public int getVideoCount() {
		int count = 0;
		for(Content c : contents) {
			if(c instanceof Video)count++;
		}
		return count;
	}
	
	public int getBookCount() {
		int count = 0;
		for(Content c : contents) {
			if(c instanceof Book2) count++;
		}
		return count;
	}
	
	public void rentContent(int id) throws IdNotFoundException {
		for(Content c : contents) {
			if(c.getId() == id) {
				c.setStatus(true);
				return;
			}
		}
		throw new IdNotFoundException(id);
	}
	
	public void rentBook(int id) throws IdNotFoundException {
		for(Content c : contents) {
			if(c.getId() == id && c instanceof Book2) {
//				rentContent(id);
				c.setStatus(true);
				return;
			}
		}
		
		System.out.print("해당 콘텐츠는 도서가 아님: ");
		throw new IdNotFoundException(id);
		
	}
	
	public void rentVideo(int id) throws IdNotFoundException {
		for(Content c : contents) {
			if(c.getId() == id && c instanceof Book2) {
//				rentContent(id);
				c.setStatus(true);
				return;
			}
		}
		
		System.out.print("해당 콘텐츠는 비디오가 아님: ");
		throw new IdNotFoundException(id);
	}
	
	public void returnContent(int id) throws IdNotFoundException{
		for(Content c : contents) {
			if(c.getId() == id) {
				c.setStatus(false);
				return;
			}
		}
		
		throw new IdNotFoundException(id);
	}
	
	public void findContentById(int id) throws IdNotFoundException {
		for(Content c: contents) {
			if(c.getId() == id) {
				System.out.println(c.toString());
				return;
			}
		}
		
		throw new IdNotFoundException(id);
	}
	
	public void findBookById(int id) throws IdNotFoundException {
		
		for(Content c: contents) {
			if(c.getId() == id) {
				try {
					Book2 result = (Book2)c;
					System.out.println(c.toString());
					return;
				}catch(ClassCastException e) {
					System.out.println("해당 관리번호는 도서가 아님");
					return;
				}
			}
		}
		
		throw new IdNotFoundException(id);
	}
//	
//	public void findVideoById(int id) throws IdNotFoundException {
//		findContentById(id);
//	}
	
	public void printAll() {
		System.out.println(Arrays.deepToString(contents.toArray()));
	}
	
	public void updatePrice(int id, int price) throws IdNotFoundException {
		for(Content c: contents) {
			if(c.getId() == id) {
				c.setPrice(price);
				return;
			}
		}
		throw new IdNotFoundException(id);
			
	}
	
	public void removeContent(int id) throws IdNotFoundException {
		for(Content c: contents) {
			if(c.getId() == id) {
				contents.remove(c);
				return;
			}
		}
		throw new IdNotFoundException(id);
	}

}
/*
 * 비디오,도서 대여점 관리 프로그램을 만들려고 한다.

관리항목은 비디오(관리번호,제작사,제목,상영시간,대여료,대여상태)
도서(관리번호,저자,제목,페이지수,대여료,대여상태)이다

대여매니저클래스를 작성하고 테스트 클래스도 작성하세요.

대여매니저클래스:
비디오등록메서드는 등록시 관리번호 중복시 관리번호중복예외를 발생시킨다.
도서등록메서드는 등록시 관리번호 중복시 관리번호중복예외를 발생시킨다.
총등록갯수메서드는 등록된 총갯수를 반환한다.
비디오등록갯수메서드는 등록된 비디오총갯수를 반환한다.
도서등록갯수메서드는 등록된 도서총갯수를 반환한다.
도서대여메서드는 관리번호를 받아 대여상태를 "대여"상태로 한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
비디오대여메서드는 관리번호를 받아 대여상태를 "대여"상태로 한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
도서검색메서드는 관리번호를 받아 도서정보를 반환한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
비디오검색메서드는 관리번호를 받아 비디오정보를 반환한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
전체출력메서드를 작성한다.

테스트 클래스:
비디오 2개, 도서 2개를 등록한다.
총등록갯수를 출력한다.
비디오등록갯수를 출력한다.
도서등록갯수를 출력한다.

등록된 도서중 하나를 검색하여 정보를 출력한다.
등록된 비디오중 하나를 검색하여 정보를 출력한다.

등록된 도서중 하나를 대여한다.
등록된 비디오중 하나를 대여한다.

등록된 모든 비디오와 도서를 출력한다.
 */