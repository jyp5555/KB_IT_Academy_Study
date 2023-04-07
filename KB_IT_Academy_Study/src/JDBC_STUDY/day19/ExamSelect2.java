package JDBC_STUDY.day19;
import java.sql.*;

public class ExamSelect2 {

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
		String sql = "SELECT * FROM BBS WHERE POST_ID=22";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
//		ResultSet 커서는 실 데이터 이전 위치
//		원래는 read-only였음, 지금은 수정도 가능
		if(rs.next()) {
			System.out.print(rs.getInt("POST_ID"));
			System.out.print("\t");
			System.out.print(rs.getString("TITLE"));
			System.out.print("\t");
			System.out.print(rs.getString("WRITER"));
			System.out.print("\t");
			System.out.print(rs.getString("POST_CONTENT"));
			System.out.print("\t");
			System.out.print(rs.getDate("REGDATE"));
			System.out.print("\n");
		}else {
			System.out.println("삭제된 게시물입니다.");
		}
		System.out.println("Select success");
		
		stmt.close();
		con.close();
	}
}
