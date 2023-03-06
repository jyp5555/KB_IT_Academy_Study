package day03;

public class ExamPerson {

	public static void main(String[] args) {
		
		/**
		 * 메소드 변수  tempPerson
		 * @author student
		 */
		Person tempPerson;
		tempPerson = new Person("김철수", 20);
		
		System.out.println(tempPerson.getName() +" || "+ tempPerson.getAge());
		
		tempPerson.setName("홍길동");
		tempPerson.setAge(21);
		
		System.out.println(tempPerson.getName() +" || "+ tempPerson.getAge());
	}
}
