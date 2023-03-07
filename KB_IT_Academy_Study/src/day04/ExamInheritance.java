package day04;

public class ExamInheritance {

	public static void main(String[] args) {
		
		S s1  = new S();
		s1.setName("");
		s1.setAge(0);
		s1.major = "";
		
		System.out.println(s1);
	}

}

class P {
	
	private String name;
	private int age;
	
	public P() {
		super();
	}

	public P(String name, int age) {
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

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}
}

/**
 * 상속의 단점 추가만 가능
 * extends 단일 상속!
 * @author student
 */
class S extends P{
	String major;

	public S() {
		super();
	}

	public S(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString()+", major=" + major;
	}
}