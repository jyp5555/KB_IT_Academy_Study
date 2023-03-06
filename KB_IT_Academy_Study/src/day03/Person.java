package day03;

/**
 * 사람에 대한 기본 정보 정의<br>
 * 이름, 나이
 * @author student
 */
public class Person {
	/**
	 * static변수
	 * 여러 인스턴스가 공유해서 사용할 수 있는 변수
	 * 프로세스가 메모리에 로드되는 순간 정적변수 영역(데이터 영역)에 생성되는 변수
	 */
//	private static final int FEMALE = 0;
//	private static final int MALE = 1;
//	private boolean gender;

	/**
	 * 인스턴스 (멤버) 변수, 힙 공간에 있음
	 */
	private String name;
	private int age;
	
	public Person() {}
	
	/**
	 * person 객체 생성자2
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
