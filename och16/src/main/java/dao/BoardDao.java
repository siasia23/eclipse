package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DAO

// 1. ListAction
// 2. ContentAction
public class BoardDao {

	private static BoardDao instance;
	
	public BoardDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDao getInstance() {
		
		if (instance == null) {
			
			instance =  new BoardDao();
			
		}
		
		return instance;
		
	}

	private Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return conn;
		
	}
	
	// 1. ListAction
	// 게시판 총 갯수 세기
	public int getTotalCnt() throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int totCnt = 0;
		
		String sql = "select count(*) from board";
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				totCnt = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
			
		}
		
		return totCnt;
		
	}

	// 1. ListAction
	// 게시판 전체 리스트 뿌리기
	public List<Board> boardList(int startRow, int endRow) throws SQLException {

		List<Board> list = new ArrayList<Board>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT *"
						+ " FROM"
						+ "    (SELECT ROWNUM rn, a.*"
						+ "    from"
						+ "        (SELECT *"
						+ "        FROM board"
						+ "        ORDER BY ref DESC, re_step) a)"
						+ " where rn between ? and ?";
		System.out.println("sql : " + sql);
		System.out.println("startRow : " + startRow);
		System.out.println("endRow : " + endRow);
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
		
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				
				Board board = new Board();
				
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				board.setRef(rs.getInt("ref"));
				board.setRe_level(rs.getInt("re_level"));
				board.setRe_step(rs.getInt("re_step"));
				board.setReg_date(rs.getDate("reg_date"));
				
				list.add(board);
				
			}
		
			System.out.println("list.size() : " +list.size());
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {

			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		
		}
		
		return list;
	}

	// 2. ContentAction
	// num의 readCount 증가 - 과제
	public void readCount(int num) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update board set readcount=readcount+1 where num=?";
		System.out.println("sql : " + sql);
		
		try {
			
			Board board = new Board();
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		}
		
	}

	// 2. ContentAction
	// 클릭한 게시판의 내용 뿌리기
	public Board select(int num) throws SQLException {
		
		Board board = new Board();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select num, subject, writer, reg_date, readcount, ip, email, content from board where num=?";
		System.out.println("sql : " + sql);

		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				board.setNum(num);
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		}
		
		return board;
	}
	
}
