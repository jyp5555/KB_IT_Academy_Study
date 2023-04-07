package JDBC_STUDY.day20;

import java.sql.*;

public class DBManager {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "spring";
		String password = "spring";
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void releaseConnection(Statement stmt, Connection con) {
		if(stmt != null) {
			try {
				 stmt.close();
			}catch (SQLException e) {
			}
		}
		if(con!= null) {
			try {
				con.close();
			}catch (SQLException e) {
			}
			
	    }
	}
	
	public static void releaseConnection(ResultSet rs, Statement stmt, Connection con) {
		if(rs != null) {
			try {
				 rs.close();
			}catch (SQLException e) {
			}
		}
		if(stmt != null) {
			try {
				 stmt.close();
			}catch (SQLException e) {
			}
		}
		if(con!= null) {
			try {
				con.close();
			}catch (SQLException e) {
			}
			
	    }
	}
}
