package JDBC_STUDY.day19;

import java.sql.*;

public class DBManager {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "HR";
	private static String password = "hr";

	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void releaseConnection(Statement stmt, Connection con) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
}
