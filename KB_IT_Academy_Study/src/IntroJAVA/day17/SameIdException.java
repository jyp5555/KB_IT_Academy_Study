package IntroJAVA.day17;

public class SameIdException extends Exception {
	private int sameId;

	public SameIdException(int sameId) {
		super();
		this.sameId = sameId;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "동일아이디가 이미 존재함: "+sameId;
	}
}
