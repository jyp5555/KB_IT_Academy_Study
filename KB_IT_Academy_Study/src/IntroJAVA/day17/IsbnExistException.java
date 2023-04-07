package IntroJAVA.day17;

public class IsbnExistException extends Exception {
	private Book book;

	public IsbnExistException(Book book) {
		this.book = book;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "같은 도서가 이미 존재함"+book.toString();
	}
}
