package day05;

public class ExamClassMember {

	public static void main(String[] args) {
		AA.staticVar  = 5;
		System.out.println(AA.staticVar);//5
		AA a1 = new AA();
		a1.i = 0;
		System.out.println(a1.staticVar);//5
		a1.staticVar = 1;
		System.out.println(a1.staticVar);//1
	}
}

class AA {
	int i;
	/**
	 * static 변수는 클래스 영역에 한 번 생성되어 공유됨 <br>
	 * 따라서 클래스 객체 생성 하고 사용할 필요 없음 <br> 
	 * 클래스.static변수 =~로 사용 권장! <- static way <br>
	 * static 변수나 static 메서드는 모두 static 공간에 있음. 클래스 변수와 메서드에 접근 불가, <strong>힙</strong> 공간에 있기 때문 <br>
	 * <a href="https://stackoverflow.com/questions/17500259/static-variables-in-multithreading">관련 문서</a>
	 */
	static int staticVar;
	
}