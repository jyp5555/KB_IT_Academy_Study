package JDBC_STUDY.day20;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PostDao {
	
	public void postBbs(PostDto post, String id) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String isMember = "SELECT COUNT(*) FROM MEMBER WHERE ID="+id;
		
		try {
			con = DBManager.getConnection();
			if(con.createStatement().executeQuery(isMember).getInt(1) >= 1 && id == post.getWriter_id()) {
				String insertBbs = "INSERT INTO bbs VALUES(bbs_seq.nextval,?,?,?,sysdate)";
				pstmt = con.prepareStatement(insertBbs);
				pstmt.setString(1, post.getTitle());
				pstmt.setString(2, post.getWriter_id());
				pstmt.setString(3, post.getContent());
				pstmt.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(pstmt, con);
		}
	}
	
	public PostDto getOneBbs(PostDto post) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PostDto result = new PostDto();
		
		try {
			con = DBManager.getConnection();
			String selectBbs = "SELECT * FROM BBS WHERE NO=?";
			pstmt = con.prepareStatement(selectBbs);
			pstmt.setInt(1, post.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new PostDto(rs.getInt("no"),rs.getString("title"),rs.getString("writer_id"), rs.getString("content"), rs.getDate("regdate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs,pstmt, con);
		}
		
		return result;
	}
	
	public List<PostDto> getAllBbs() throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PostDto> postList = new ArrayList<>();
		
		
		try {
			con = DBManager.getConnection();
			String selectBbs = "SELECT * FROM BBS";
			pstmt = con.prepareStatement(selectBbs);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				postList.add(new PostDto(rs.getInt("no"),rs.getString("title"),rs.getString("writer_id"), rs.getString("content"), rs.getDate("regdate")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs,pstmt, con);
		}
		
		return postList;
	}
	
	public List<String> getAllWriterName() throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> writerList = new ArrayList<>();
		
		
		try {
			con = DBManager.getConnection();
			String selectBbs = "SELECT MEMBER.NAME AS NAME FROM BBS, MEMBER WHERE BBS.WRITER_ID=MEMBER.ID";
			pstmt = con.prepareStatement(selectBbs);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				writerList.add(rs.getString("name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs,pstmt, con);
		}
		
		return writerList;
	}
	
	public HashMap<String,ArrayList<PostDto>> getMemberPostList() throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String,ArrayList<PostDto>> result = new HashMap<>();
		
		
		try {
			con = DBManager.getConnection();
			String selectBbs = "SELECT BBS.* FROM BBS, MEMBER WHERE BBS.WRITER_ID=MEMBER.ID ORDER_BY BBS.WRITER_ID";
			pstmt = con.prepareStatement(selectBbs);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(result.get(rs.getString("writer_id")) != null) result.get(rs.getString("writer_id")).add(new PostDto(rs.getInt("no"), rs.getString("title"), rs.getString("writer_id"), rs.getString("content"), rs.getDate("regdate")));
				else {
					
					result.put(rs.getString("writer_id"),new ArrayList<>(Arrays.asList(new PostDto(rs.getInt("no"), rs.getString("title"), rs.getString("writer_id"), rs.getString("content"), rs.getDate("regdate")))));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs,pstmt, con);
		}
		
		return result;
	}
	
	public HashMap<String, Integer> getMemberPostCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, Integer> result = new HashMap<>();
		
		
		try {
			con = DBManager.getConnection();
			String selectBbs = "SELECT BBS.WRITER_ID AS ID, COUNT(*) AS CNT FROM BBS, MEMBER WHERE BBS.WRITER_ID=MEMBER.ID GROUP_BY BBS.WRITER_ID";
			pstmt = con.prepareStatement(selectBbs);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(result.get(rs.getString("id")) == null) result.put(rs.getString("id"), rs.getInt("cnt"));
				else result.put(rs.getString("id"), result.get(rs.getString("id"))+1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(rs,pstmt, con);
		}
		
		return result;
	}
}