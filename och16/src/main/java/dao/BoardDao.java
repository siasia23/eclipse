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
//	2-1. ContentAction, UpdateFormAction
// 3. UpdateProAction
// 4. WriteProAction
// 5. DeleteProAction
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

	// 2-1. ContentAction, UpdateFormAction, DeleteFormAction
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

	// 3. UpdateProAction
	// 게시판 내용 수정
	public int update(Board board) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "update board set subject=?, writer=?, email=?, passwd=?, content=? where num=?";
		System.out.println("sql : " + sql);
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getPasswd());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		}
		
		return result;
		
	}

	// 4. WriteProAction
	// 게시판에 새 글쓰기
	public int insert(Board board) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = board.getNum();
		int result = 0;
		
		// select 쿼리
		String selectSQL = "select nvl(max(num), 0) from board";
		System.out.println("selectSQL : " + selectSQL);
		
		// insert 쿼리
		String insertSQL = "insert into board values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate) ";
		System.out.println("insertSQL : " + insertSQL);
		
		// 댓글달기 update 쿼리
		String updateSQL = "update board set re_step = re_step + 1 where ref=? and re_step > ?";
		
		try {
			
			conn = getConnection();
			
			// select 쿼리 삽입
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int number = rs.getInt(1) + 1;
			
			rs.close();
			pstmt.close();
			
			// 댓글달기 update 쿼리 삽입
			if (num != 0) {
				
				System.out.println("댓글 쿼리 updateSQL : " + updateSQL);
				System.out.println("댓글 board.getRef() : " + board.getRef());
				System.out.println("댓글 board.getRe_step() : " + board.getRe_step());
				
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setInt(1, board.getRef());
				pstmt.setInt(2, board.getRe_step());
				
				pstmt.executeUpdate();
				
				pstmt.close();
				
				// 댓글 관련 정보
				board.setRe_step(board.getRe_step()+1);
				board.setRe_level(board.getRe_level()+1);
				
			}
			
			// 신규 글이면 num = ref 맞춰줌
			if (num == 0) board.setRef(number);
			
			// insert 쿼리 삽입
			pstmt = conn.prepareStatement(insertSQL);
			
			pstmt.setInt(1, number);
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getEmail());
			pstmt.setInt(6, board.getReadcount());
			pstmt.setString(7, board.getPasswd());
			pstmt.setInt(8, board.getRef());
			pstmt.setInt(9, board.getRe_step());
			pstmt.setInt(10, board.getRe_level());
			pstmt.setString(11, board.getIp());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		}
		
		return result;
	}


	// 5. DeleteProAction
	// 게시판 글 삭제
	public int delete(int num, String passwd) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			conn = getConnection();
			
			String sql = "delete from board where num=? and passwd=?";
			System.out.println("sql : " + sql);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, passwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		}
		
		return result;
	}
	
}
