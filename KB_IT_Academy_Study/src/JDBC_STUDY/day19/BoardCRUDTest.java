package JDBC_STUDY.day19;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardCRUDTest {

	public static void main(String[] args) {
		try {
//			insert();
//			update();
//			System.out.println(count());
//			System.out.println(selectOne());
			System.out.println(Arrays.deepToString(selectAll().toArray()));
		} catch (Exception e) {
			
		}
		
		
	}

	private static List<BbsDto> selectAll() {
		List<BbsDto> list = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from BBS order by post_id desc";//최신글 우선
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                BbsDto dto = new BbsDto();
                dto.setPost_id(rs.getInt("post_id"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPost_content(rs.getString("post_content"));
                dto.setRegdate(rs.getDate("regdate"));
                list.add(dto);
            }
            DBManager.releaseConnection(pstmt, con);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
	}

	private static String selectOne() {
		int id = 24;
		BbsDto dto = null;
		
		Connection con;
		try {
			con = DBManager.getConnection();
			String sql = "select * from bbs where post_id=?";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BbsDto();
				dto.setPost_id(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPost_content(rs.getString("post_content"));
				dto.setRegdate(rs.getDate("regdate"));
			}
			DBManager.releaseConnection(pstmt, con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto.toString();
	}

	private static int count() {
		int count = -1;
	
		Connection con;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT COUNT(*) FROM BBS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
			DBManager.releaseConnection(stmt, con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return count;	
	}

	private static void insert() throws ClassNotFoundException, SQLException {
		
		BbsDto dto = new BbsDto();
		dto.setTitle("6등");
		dto.setWriter("u01");
		dto.setPost_content("야~ 6등이다.");
		Connection con = DBManager.getConnection();
		
		String sql = "INSERT INTO BBS VALUES(BBS_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getWriter());
		pstmt.setString(3, dto.getPost_content());
		int count = pstmt.executeUpdate();
		
		DBManager.releaseConnection(pstmt, con);
		
	}
	
	private static void update() {
		BbsDto dto = new BbsDto();
		dto.setPost_id(24);
		dto.setTitle("6등");
		dto.setWriter("u01");
		dto.setPost_content("야~6등이다-수정");
		
		Connection con;
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE BBS SET POST_CONTENT=? WHERE POST_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPost_content());
			pstmt.setInt(2, dto.getPost_id());
			int count = pstmt.executeUpdate();
			DBManager.releaseConnection(pstmt, con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
