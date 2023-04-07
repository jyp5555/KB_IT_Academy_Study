package IntroJAVA.day17;

public class IsbnNotFoundException extends Exception {
	private String isbn;

	public IsbnNotFoundException(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "찾는 도서가 존재하지 않음: "+isbn;
	}
}
