package JDBC_STUDY.day20;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	public void post(MemberDto member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String postMember = "INSERT INTO member VALUES(?,?,?,?)";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(postMember);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getIntro());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
	}
	
	public void put(MemberDto member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String putMember = "UPDATE MEMBER SET PASSWORD=?, NAME=?, INTRO=? WHERE ID=?";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(putMember);			
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getIntro());
			pstmt.setString(4, member.getId());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
	}
	
	public MemberDto getOne(MemberDto member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectMember = "SELECT * FROM MEMBER WHERE ID=?";
		MemberDto result = new MemberDto();
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(selectMember);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setId(member.getId());
				result.setName(rs.getString("name"));
				result.setPassword(rs.getString("password"));
				result.setIntro(rs.getString("intro"));
			}
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return result;
	}
	
	public List<MemberDto> getAll() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectAllMember = "SELECT * FROM MEMBER";
		List<MemberDto> memberList = new ArrayList<>();
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(selectAllMember);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto resultMember = new MemberDto(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("intro"));
				memberList.add(resultMember);
			}
		} finally {
			DBManager.releaseConnection(rs,pstmt, con);
		}
		
		return memberList;
	}
	
	public void deleteOne(MemberDto member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteMember = "DELETE MEMBER WHERE ID=?";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(deleteMember);
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
	}
	
	public void deleteAll() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteMember = "DELETE FROM MEMBER";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(deleteMember);
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
	}
	
	public int getCount() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String deleteMember = "SELECT COUNT(*) FROM MEMBER";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(deleteMember);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return result;
	}
}
