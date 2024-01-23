package och12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// Singleton + DBCP > 메모리 절감, DOS 공격에 강함(?)
public class MemberDao {

	private static MemberDao instance;
	
	// private 기본 생성자
	private MemberDao() {

		// Connection 얻기
//		getConnection();
		
	}
	
	// private 생성자 얻는 public getInstance()
	public static MemberDao getInstance() {
		
		if (instance == null) {
			instance = new MemberDao();
		}
		
		return instance;
		
	}
	
	// private Connection 객체
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
	
	// 과제 2
	// PreparedStatement 사용
	public int check(String id, String passwd) throws SQLException {
		
		Member2 member2 = new Member2();
		
		String sql = "select id, passwd from member2 where id=?";
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
		
			member2.setId(id);
			member2.setPasswd(passwd);
			
			rs.close();
			pstmt.close();
			getConnection().close();
			
			return 1;
			
		} else return 0;
		
	}

	// 과제 3
	// PreparedStatement 사용
	public int insert(Member2 member2) throws SQLException {
		
		String sql = "insert into member2 values(?, ?, ?, ?, ?, sysdate)";
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, member2.getId());
		pstmt.setString(2, member2.getPasswd());
		pstmt.setString(3, member2.getName());
		pstmt.setString(4, member2.getAddress());
		pstmt.setString(5, member2.getTel());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		getConnection().close();
		
		return result;
		
	}
	
}
