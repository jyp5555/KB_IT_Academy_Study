package IntroJAVA.day17;

public class Magazine extends Book{
	private String periodical;
	private int periodicalNum;

	public Magazine(String iSBN, String title, int price, String publisher , String periodical, int periodicalNum) {
		super(iSBN, title, price, publisher);
		this.periodical = periodical;
		this.periodicalNum = periodicalNum;
	}

	public String getPeriodical() {
		return periodical;
	}

	public void setPeriodical(String periodical) {
		this.periodical = periodical;
	}

	public int getPeriodicalNum() {
		return periodicalNum;
	}

	public void setPeriodicalNum(int periodicalNum) {
		this.periodicalNum = periodicalNum;
	}

	@Override
	public String toString() {
		return super.toString()+", periodical=" + periodical + ", periodicalNum=" + periodicalNum;
	}
}
