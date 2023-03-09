package IntroJAVA.day03;

public class ExamCall {

	public static void main(String[] args) {
		
		/**
		 * 변수가 가지고 있는 값만 조작한 거임...
		 * 변수의 내용을 바뀐게 아님...
		 * 수학에서도, x=2 , f(x) = x+2라고 할 때, x값은 똑같이 2이고 그냥 함수 결과만 4이다.
		 * CallbyValue
		 */
		int a = 100;
		System.out.println("a: "+a);
		change(a);
		System.out.println("a: "+a);//왜 200이 안될까? 
		
		/**
		 * arr: 시작위치(참조값)가 저장
		 * change2()에 시작위치가 넘어가서 1번째 요소의 값이 바뀜
		 * CallbyReference
		 */
		int[] arr = new int[] {100,200,300};
		change2(arr);
		System.out.println(arr[1]);//왜 900으로 바뀜
	}


	private static void change(int a) {
		a = 200;
	}
	
	private static void change2(int[] arr) {
		arr[1] = 900;
	}

}
