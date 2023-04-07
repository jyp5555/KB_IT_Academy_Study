package JDBC_STUDY.day19;
import java.sql.*;

public class ExamConnection {

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
		String sql = "INSERT INTO BBS VALUES(";
		sql+="BBS_SEQ.NEXTVAL,'3등','u01', '아~3등이다.',sysdate)";
		Statement stmt = con.createStatement();
		int count = stmt.executeUpdate(sql);
		System.out.println("Insert success");
		
//		ResultSet객체, rs.next()(실제 데이터 결과를 한 행씩 가리키는 커서가 옮겨가면서 데이터 존재 시 True반환)
		sql = "UPDATE BBS SET POST_CONTENT='아~3등이다-수정' WHERE POST_ID=21";
		count = stmt.executeUpdate(sql);
		System.out.println("update success "+count);
		
		stmt.close();
		con.close();
	}
}
