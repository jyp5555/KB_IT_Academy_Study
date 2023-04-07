package IntroJAVA.day18;

public class Content {
	private int id;
	private String title;
	private int price;
	private boolean status;
	
	public Content(int id, String title, int price, boolean status) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "id=" + id + ", title=" + title + ", price=" + price + ", status=" + status;
	}
	
	
}
