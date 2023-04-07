package JDBC_STUDY.day19;
import java.sql.*;

public class ExamInsert2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		실행 중 클래스 찾아 메모리 로딩
//		동적로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩");
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="HR";
		String password="hr";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("연결 성공");
		
//		Statement: SQL전송
//		PreparedStatement :pre-compile 기능 제공, 배치 작업(대용량 일괄처리)
//		CallableStatement
//		오라클 구문파싱(컴파일, 보통 서버) -> 클라이언트단에서 하는 컴파일(preparedstatement, 해킹의 소지 적도록, 서버부하가 낮도록)
		String sql = "INSERT INTO BBS VALUES(BBS_SEQ.NEXTVAL,?,?,?,sysdate)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "4");
		pstmt.setString(2, "4");
		pstmt.setString(3, "4");
		int count = pstmt.executeUpdate();// sql을 미리 넣어놨음...
		System.out.println("Insert success");

		pstmt.close();
		con.close();
	}
}
