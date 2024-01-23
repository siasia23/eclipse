package och11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DAO : DB CRUD에 관련된 DML 처리 로직을 모아놓는 곳
public class MemberDao {

	// 1. 선언 (멤버변수)
	Connection conn = null;
	
	// DBCP로 연결
	private Connection getUserConn() throws SQLException {
		
		try {
			
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();	// 2. 선언된 것을 가지고 연결
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		return conn;	// return (Connection type Object)
		
	}	// getUserConn()
	
	public int insert(MemberDto member) throws SQLException{
		
		// getUserConn() 사용
		// PreparedStatement 사용
		
		getUserConn();
		
		String sql = "insert into member1 values(?, ?, ?, sysdate)";
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getName());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
		
	}
	
}
