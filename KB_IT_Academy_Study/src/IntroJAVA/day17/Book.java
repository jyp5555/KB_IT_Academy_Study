package IntroJAVA.day17;

public class Book {
	private String ISBN;
	private int price;
	private String publisher;
	private String title;
	
//	public Book() {
//		super();
//	}

	public Book(String iSBN, String title, int price, String publisher) {
		super();
		ISBN = iSBN;
		this.price = price;
		this.publisher = publisher;
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}	

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ISBN=" + ISBN + ", price=" + price + ", publisher=" + publisher + ", title=" + title;
	}
	
}
