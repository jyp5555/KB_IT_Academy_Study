package IntroJAVA.day18;

public class IdNotFoundException extends Exception {
	private int absentId;

	public IdNotFoundException(int absentId) {
		super();
		this.absentId = absentId;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "관리번호가 존재하지 않음: "+absentId;
	}
}
