package IntroJAVA.day17;

public class Book2 extends Content{
	
	private String author;
	private int pages;
	
	public Book2(int id, String title, int price, boolean status, String author, int pages) {
		super(id, title, price, status);
		this.author = author;
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return super.toString()+", author=" + author + ", pages=" + pages;
	}

}
