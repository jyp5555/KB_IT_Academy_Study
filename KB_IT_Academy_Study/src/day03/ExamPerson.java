package day03;

public class ExamPerson {

	public static void main(String[] args) {
		
		/**
		 * 메소드 변수  tempPerson
		 * @author student
		 */
		Person tempPerson1;
//		System.out.println(tempPerson1.getAge()); => may not have initialized (선언만 함, 명시적 초기화 필요)
		tempPerson1 = new Person("김철수", 20);
//		System.out.println(tempPerson1.getName() +"의 나이는 "+ tempPerson1.getAge()); 
		tempPerson1.printInfo();
		
		tempPerson1.setName("홍길동");
		tempPerson1.setAge(21);
//		System.out.println(tempPerson1.getName() +"의 나이는 "+ tempPerson1.getAge());
		tempPerson1.printInfo();
		
		/**
		 * tempPerson1,2 은 서로 다름
		 */
		Person tempPerson2 = new Person("김영희",22);
//		System.out.println(tempPerson2.getName() +"의 나이는 "+ tempPerson2.getAge());
		tempPerson2.printInfo();


//		Person tempPerson3 = new Person(); tempPerson3.name = null, tempPerson3.age = 0
		
	}
}
