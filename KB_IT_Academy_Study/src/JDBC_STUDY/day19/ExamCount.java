package JDBC_STUDY.day19;
import java.sql.*;

public class ExamCount {

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
		String sql = "SELECT COUNT(*) AS CNT FROM BBS";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
//		ResultSet 커서는 실 데이터 이전 위치
//		원래는 read-only였음, 지금은 수정도 가능
//		if, while, X
//		while(rs.next()) {
//			System.out.println(rs.getInt(1));
//		} <-  count(*)라서
		
		rs.next();
		System.out.println(rs.getInt("CNT"));
		
		System.out.println("Select success");
		
		stmt.close();
		con.close();
	}
}
