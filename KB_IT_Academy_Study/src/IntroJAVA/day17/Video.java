package IntroJAVA.day17;

public class Video extends Content{
	private String producer;
	private int runningTime;
	
	public Video(int id, String title, int price, boolean status, String producer, int runningTime) {
		super(id, title, price, status);
		this.producer = producer;
		this.runningTime = runningTime;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return super.toString()+", producer=" + producer + ", runningTime=" + runningTime;
	}
}

/*
 * 비디오,도서 대여점 관리 프로그램을 만들려고 한다.

관리항목은 비디오(관리번호,제작사,제목,상영시간,대여료,대여상태)
도서(관리번호,저자,제목,페이지수,대여료,대여상태)이다

대여매니저클래스를 작성하고 테스트 클래스도 작성하세요.

대여매니저클래스:
비디오등록메서드는 등록시 관리번호 중복시 관리번호중복예외를 발생시킨다.
도서등록메서드는 등록시 관리번호 중복시 관리번호중복예외를 발생시킨다.
총등록갯수메서드는 등록된 총갯수를 반환한다.
비디오등록갯수메서드는 등록된 비디오총갯수를 반환한다.
도서등록갯수메서드는 등록된 도서총갯수를 반환한다.
도서대여메서드는 관리번호를 받아 대여상태를 "대여"상태로 한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
비디오대여메서드는 관리번호를 받아 대여상태를 "대여"상태로 한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
도서검색메서드는 관리번호를 받아 도서정보를 반환한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
비디오검색메서드는 관리번호를 받아 비디오정보를 반환한다. 관리번호가 없으면 관리번호NotFound예외를 발생한다.
전체출력메서드를 작성한다.

테스트 클래스:
비디오 2개, 도서 2개를 등록한다.
총등록갯수를 출력한다.
비디오등록갯수를 출력한다.
도서등록갯수를 출력한다.

등록된 도서중 하나를 검색하여 정보를 출력한다.
등록된 비디오중 하나를 검색하여 정보를 출력한다.

등록된 도서중 하나를 대여한다.
등록된 비디오중 하나를 대여한다.

등록된 모든 비디오와 도서를 출력한다.
 */