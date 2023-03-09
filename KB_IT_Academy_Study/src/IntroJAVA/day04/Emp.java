package IntroJAVA.day04;

public class Emp extends Person{
		
	private String department;
	
//	생성자 함수가 없을 때, 컴파일러가 기본생성자 삽입
//	public Emp(){super();} <- 부모클래스에도 기본생성자 있어야함

	public Emp(String name, int age, String department) {
		super(name,age);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + ", 부서: " + department;
	}
}