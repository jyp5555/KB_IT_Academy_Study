package IntroJAVA.day03;

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
	
	/**
	 * person 객체 생성자1 기본생성자
	 * 생성자는 클래스 명과 동일, 리턴 타입 없음
	 * 생성자 없으면 컴파일러가 일단 기본 생성자를 띄움
	 * 만약 파라미터 사용한 생성자가 있으면, 기본 생성자를 띄우지 않음...
	 */
	public Person() {}
	
	/**
	 * person 객체 생성자2
	 * @param String name
	 * @param int age
	 */
	public Person(String name, int age) {
		super();
		System.out.println("this는"+ this);
		/**
		 * this -> 객체 자신의 시작위치를 가리킴
		 */
		this.name = name;
		this.age = age;
	}

	/**
	 * person 객체 생성자3
	 * @param age
	 * @param name
	 */
	public Person(int age, String name) {
		/**
		 * 다른 생성자 호출
		 */
		this(name,age);
//		super();
//		this.name = name;
//		this.age = age;
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
	
	/**
	 * Object 최상위 부모 상속 오버라이딩
	 */
	@Override
	public String toString() {
		return name+"의 나이는 "+age;
	} 
	
	/**
	 */
	public void printInfo() {
		System.out.println(name+"의 나이는 " + age);//처리속도 60ms, 메모리 60ns -> 100만배 느림...
	}
}
