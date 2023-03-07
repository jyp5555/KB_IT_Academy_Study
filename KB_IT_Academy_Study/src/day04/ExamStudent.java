package day04;

public class ExamStudent {

	public static void main(String[] args) {
		Student st1 = new Student("ghd",1,"컴공");
		System.out.println(st1);
		
		Emp e1 = new Emp("김대리",32,"영업부");
		System.out.println(e1);
		
//		다형성
//		부모타입 = 자식타입
//		부모.멤버변수
		Person p1 = e1;
		System.out.println(p1.getName());
//		System.out.println(p1.getDepartment());
//		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//			The method getDepartment() is undefined for the type Person
//
//			at day04.ExamStudent.main(ExamStudent.java:16)
		System.out.println(p1);
		
		
	/**
	 * ++++++++++++++++++++++++++++++++++
	 * +					+			+
	 * + e1 _____________	+			+
	 * +|dept			 |  +<----	    +      
	 * +|================|  +<-   !  	+      
	 * +|person(name,age)|	+ |	  !		+			
	 * +|________________|  + |p1 !e1	+
	 * +					+			+
	 * ++++++++++++++++++++++++++++++++++ <= in memory
	 */
		
		Person[] pa = new Person[5];
		pa[0] = st1;
		pa[1] = e1;
		pa[2] = new Student("2",2,"2");
		pa[3] = new Emp("3",3,"3");
		pa[4] = new Student("4",4,"4");
//		통합된 관리
	}

}
