/**
 * package: 클래스의 모음
 */
package IntroJAVA.day03;

/**
 * import : 같은 패키지 안에 있는 것은 필요 없음
 */
import java.util.Date;

public class ExamPerson2 {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동",300);
		p1.printInfo();
		p1.setName("김길동");
		p1.setAge(1);
		System.out.println(p1.getName()+"의 나이는 "+p1.getAge());
		
		/**
		 * p1이 참조변수이기 때문에 같다!
		 */
		System.out.println(p1);
		System.out.println(p1.toString());
		
		p1.printInfo();

		
		Person p2 = new Person(30,"홍길동");
		p2.printInfo();
		
		Date date1 = new Date();
	}
	
	/**
	 * 제어자: 접근제어자
	 * public
	 * protected
	 * (default): 
	 * private: 동일 클래스 내
	 */
}
