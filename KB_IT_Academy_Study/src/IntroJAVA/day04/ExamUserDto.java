package IntroJAVA.day04;

public class ExamUserDto {

	public static void main(String[] args) {
		
		UserDto user = new UserDto();
		
//		toString() 구현 전: day04.UserDto@6f2b958e <-hashCode
//		toString() 구현 후: User [userSeq=0, name=null, email=null, phone=null, isSleep=false]
		System.out.println(user);
	}
}
