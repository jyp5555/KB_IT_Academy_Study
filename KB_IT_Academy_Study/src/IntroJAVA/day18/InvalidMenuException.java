package IntroJAVA.day18;

public class InvalidMenuException extends Exception {
	private int invalidMenu;

	public InvalidMenuException(int invalidMenu) {
		super();
		this.invalidMenu = invalidMenu;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "유효하지 않은 메뉴: "+invalidMenu;
	}
	
	
}
