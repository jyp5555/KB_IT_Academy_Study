package IntroJAVA.day17;

import java.util.ArrayList;
import java.util.Arrays;

public class BookManager {
	private ArrayList<Book> books;

	public static void main(String[] args) {
        BookManager bm = new BookManager(); 
        try {
			bm.add( new Book("123-123","자바기본",20000,"한빛") );
		} catch (IsbnExistException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
        try {
			bm.add( new Book("123-222","SQL",30000,"길벗") );
		} catch (IsbnExistException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
        try {
			bm.add( new Magazine("222-333","월간마소",25000,"한울","1달",3) );
		} catch (IsbnExistException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
        try {
			bm.add( new Magazine("222-433","주간프로그래밍",20000,"삼양","1주",20) );
		} catch (IsbnExistException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
        System.out.println("등록갯수: "+bm.getCount());
        
        Book b = null;
		try {
			b = bm.findByIsbn("123-123");
		} catch (IsbnNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
        System.out.println("검색성공;"+b.toString());
        System.out.println("등록갯수: "+bm.getCount());
        try {
            b = bm.findByIsbn("123-223");
            System.out.println("검색성공:"+b.toString());
        } catch (Exception e) {
            System.out.println("미등록 도서:"+e.getMessage());
        }
        System.out.println("등록갯수: "+bm.getCount());
       
        //수정
        try {
            b.setPrice(22000);
            bm.update( b );
        } catch (Exception e) {
            System.out.println("미등록 도서:" + e.getMessage());
        }
        //삭제
        try {
            b = bm.findByIsbn("222-433");
            System.out.println("검색성공:"+b.toString());
            bm.delete(b);
            System.out.println("삭제성공:"+b.toString());
        } catch (Exception e) {
            System.out.println("미등록 도서:"+e.getMessage());
        }
//        
    }
	
	public BookManager() {this.books = new ArrayList<>();}
	
	//등록
	public void add(Book b) throws IsbnExistException{
		for(Book book: books) {
			if(book.getISBN().equals(b.getISBN())) throw new IsbnExistException(b);
		}
		books.add(b);
	}
	public void add(Magazine  b) throws IsbnExistException{
//		for(Book book: books) {
//			if(book.getISBN().equals(b.getISBN())) throw new IsbnExistException(b);
//		}
//		books.add(b);
		add((Book) b);
	}
	//검색
	public int  getCount(){
		return books.size();		
	}
	public ArrayList<Book> list(){
		return books;
	}
	public Book findByIsbn(String isbn) throws IsbnNotFoundException{
		for(Book book: books) {
			if(book.getISBN().equals(isbn)) return book;
		}
		throw new IsbnNotFoundException(isbn);
	}
	//수정
	public void update(Book b) throws IsbnNotFoundException{
		for(int i = 0; i<books.size();i++) {
			if(books.get(i).getISBN().equals(b.getISBN())) {
				books.set(i, b);
				return;
			}
		}
		throw new IsbnNotFoundException(b.getISBN());
	}
	public void update(Magazine b) throws IsbnNotFoundException{
//		for(int i = 0; i<books.size();i++) {
//			if(books.get(i).getISBN().equals(b.getISBN())) {
//				books.set(i, b);
//				return;
//			}
//		}
//		throw new IsbnNotFoundException(b.getISBN());
		update((Book)b);
	}
	//삭제
	public void delete(Book b) throws IsbnNotFoundException{
//		for(Book book : books) {
//			if(book.getISBN().equals(b.getISBN())) {
//				books.remove(b);
//				return;
//			}
//		}
		Book book = findByIsbn(b.getISBN());
		if (book != null) {
			for(Book tempBook : books) {
				if(tempBook.getISBN().equals(b.getISBN())) {
					books.remove(b);
					return;
				}
			}
		}
		throw new IsbnNotFoundException(b.getISBN());
	}

	@Override
	public String toString() {
		return Arrays.deepToString(books.toArray());
	}
	
}
