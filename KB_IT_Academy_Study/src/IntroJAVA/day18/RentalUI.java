package IntroJAVA.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalUI {
	RentalManager rentalManager = new RentalManager();
	Scanner sc  = new Scanner(System.in);
	int[] validMenu = {1,2,3,4,5,6,7,99};
	public static void main(String[] args) throws NumberFormatException, InputMismatchException, SameIdException, IdNotFoundException, InvalidMenuException {
		RentalUI ui = new RentalUI();
		while(true) {
			try {
				ui.mainMenu();
			}catch(SameIdException | IdNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
}

	private void mainMenu() throws SameIdException, IdNotFoundException {
		System.out.println("** 도서 대여 프로그램 v0.1 **");
		System.out.println("[총 등록수: "+rentalManager.getAllCount()+"]");
		System.out.println("1)도서등록 2)비디오등록 3)대여 4)반납 5) 전체 출력 6)대여료 수정 6)삭제 99)종료");
		
		int menu;
		while(true) {
			try {
				menu = inputMenu(validMenu);
				break;
			}catch(Exception e) {
				System.out.println("재입력하세요!");
			}
		}
		
		switch(menu) {
		case(1):
			System.out.println("** 도서등록 **");
			System.out.println("1)도서정보입력 99)이전메뉴");
			while(true) {
				try {
					menu = inputMenu(new int[] {1,99});
					break;
				}catch(Exception e) {
					System.out.println("재입력하세요!");
				}
			}
			if(menu == 1) {
				addBook();
			}
			break;
			
		case(2):
			System.out.println("** 비디오등록 **");
			System.out.println("1)비디오정보입력 99)이전메뉴");
			while(true) {
				try {
					menu = inputMenu(new int[] {1,99});
					break;
				}catch(Exception e) {
					System.out.println("재입력하세요!");
				}
			}
			if(menu == 1) {
				addVideo();
			}
			break;
		case(3):
			System.out.println("** 대여 **");
			System.out.println("1)대여 99)이전메뉴");
			while(true) {
				try {
					menu = inputMenu(new int[] {1,99});
					break;
				}catch(Exception e) {
					System.out.println("재입력하세요!");
				}
			}
			if(menu == 1) {
				System.out.print("관리번호> ");
				int rentId = Integer.parseInt(sc.nextLine().strip());
				rentalManager.rentContent(rentId);
			}
			break;
		case(4):
			System.out.println("** 반납 **");
			System.out.println("1)대여 99)이전메뉴");
			while(true) {
				try {
					menu = inputMenu(new int[] {1,99});
					break;
				}catch(Exception e) {
					System.out.println("재입력하세요!");
				}
			}
			if(menu == 1) {
				System.out.print("관리번호> ");
				int rentId = Integer.parseInt(sc.nextLine().strip());
				rentalManager.returnContent(rentId);
			}
			break;
		case(5):
			rentalManager.printAll();
			break;
		case(6):
			System.out.println("** 대여료 수정 **");
			System.out.println("1)대여료 수정 99)이전메뉴");
			int id,price;
			while(true) {
				try {
					menu = inputMenu(new int[] {1,99});
					System.out.print("수정 관리번호> ");					
					id = Integer.parseInt(sc.nextLine().strip());
					System.out.print("수정 가격> ");
					price = Integer.parseInt(sc.nextLine().strip());
					break;
				}catch(Exception e) {
					System.out.println("재입력하세요!");
				}
			}
			rentalManager.updatePrice(id, price);
			break;
		case(7):
			System.out.println("** 삭제 **");
			System.out.println("1)대여료 수정 99)이전메뉴");
			int id1;
			while(true) {
				try {
					menu = inputMenu(new int[] {1,99});
					System.out.print("삭제 관리번호> ");					
					id1 = Integer.parseInt(sc.nextLine().strip());
					break;
				}catch(Exception e) {
					System.out.println("재입력하세요!");
				}
			}
			rentalManager.removeContent(id1);
		break;
		case(99):
			System.exit(0);
			return;
		}

	}
	private int inputMenu(int[] validMenus) throws InvalidMenuException, NumberFormatException, InputMismatchException {
		System.out.print("메뉴번호> ");
		int menu = Integer.parseInt(sc.nextLine().strip());
		for(int i: validMenus)
			if(i == menu) return menu;
			else continue;
		
		throw new InvalidMenuException(menu);
	}
	
	private void addBook() throws SameIdException {
		System.out.print("등록할 도서관리번호> ");
		int id = Integer.parseInt(sc.nextLine().strip());
		System.out.print("등록할 도서제목> ");
		String title = sc.nextLine().strip();
		System.out.println("등록할 도서저자> ");
		String author = sc.nextLine().strip();
		System.out.println("등록할 도서페이지수> "); 
		int pages = Integer.parseInt(sc.nextLine().strip());
		System.out.println("등록할 도서대여료> "); 
		int price = Integer.parseInt(sc.nextLine().strip());
		Book2 book = new Book2(id, title, price, false, author, pages);
		rentalManager.add(book);
		System.out.println("--> 도서가 등록되었습니다.");
	}
	
	private void addVideo() throws SameIdException {
		System.out.print("등록할 비디오관리번호> ");
		int id1 = Integer.parseInt(sc.nextLine().strip());
		System.out.print("등록할 비디오제목> ");
		String title1 = sc.nextLine().strip();
		System.out.println("등록할 비디오 제작자> ");
		String producer = sc.nextLine().strip();
		System.out.println("등록할 상영시간> "); 
		int runningTime = Integer.parseInt(sc.nextLine().strip());
		System.out.println("등록할 비디오대여료> "); 
		int price1 = Integer.parseInt(sc.nextLine().strip());
		Video video = new Video(id1, title1, price1, false, producer, runningTime);
		rentalManager.add(video);
		System.out.println("--> 비디오가 등록되었습니다.");
	}

}
