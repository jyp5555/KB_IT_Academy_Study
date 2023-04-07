package JDBC_STUDY.day19;
import java.sql.*;

public class ExamDelete2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="HR";
		String password="hr";
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "DELETE BBS WHERE POST_ID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "22");
		
		int count = pstmt.executeUpdate();// sql을 미리 넣어놨음...
		System.out.println("Update success");

		pstmt.close();
		con.close();
	}

}
