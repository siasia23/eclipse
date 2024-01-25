package och12;

// DAO
// Singleton pattern 적용

// 역할
// 1. 회원명단 : DB Connection 후 쿼리 설정 후 결과 값을 List로 생성 (List<Member2> list() Method)
// 2. 회원가입 : DB Connection 후 체크 (check Method)
// 2-1. 아이디 중복 체크 : (confirm Method)
// 3. 로그인 	 : DB Connection 후 저장 (insert Method)
// 4. 회원수정 : DB Connection 후 조회한 후 수정 (select, update Method)
// 5. 회원삭제 : DB Connection 후 삭제 (delete Method)
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

import com.mysql.cj.protocol.Resultset;

// Singleton + DBCP > 메모리 절감, DOS 공격에 강함(?)
public class MemberDao {

	private static MemberDao instance;
	
	// private 기본 생성자
	private MemberDao() {

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
			
			// InitialContext() : context.xml에 연결하라
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return conn;
		
	}
	
	// 1. 회원명단 : DB Connection 후 쿼리 설정 후 결과 값을 List로 생성 (List<Member2> list() Method)
	public List<Member2> list() throws SQLException {
			
		// java에서 배열을 쓰면 크기를 지정하고 써야하는데, DB 데이터 개수를 모른다는 가정 하에,
		// 배열 크기 지정이 필요 없는 collection (map, list..)을 써서 화면에 뿌린다.
		List<Member2> list = new ArrayList<Member2>();
		
		Connection conn = getConnection();
		
		String sql = "select id, name, address, tel, reg_date from member2";
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery(sql);
		
		while (rs.next()) {
			
			Member2 member = new Member2();
			
			member.setId(rs.getString(1));
			member.setName(rs.getString(2));
			member.setAddress(rs.getString(3));
			member.setTel(rs.getString(4));
			member.setReg_date(rs.getDate(5));
			
	        list.add(member);
		
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
		
	}

	// 2. 회원가입 : DB Connection 후 체크 (check Method)
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

	// 2-1. 아이디 중복 체크 : (confirm Method)
	public int confirm(String id) throws SQLException {
		
		Connection conn = getConnection();
		
		String sql = "select id from member2 where id=?";
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (! rs.next()) {
			
			pstmt.close();
			conn.close();
			
			return 0;
			
		} else {
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		}
		
	}
	
	// 3. 로그인 	 : DB Connection 후 저장 (insert Method)
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
	
	// 4-1. 회원수정 : DB Connection 후 조회(select Method)
	public Member2 select(String id) throws SQLException {
		
		Member2 member = new Member2();
		
		Connection conn = getConnection();
		
		String sql = "select * from member2 where id=?";
		System.out.println("id->"+id);
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			member.setId(rs.getString("id"));
			member.setPasswd(rs.getString("passwd"));
			member.setName(rs.getString("name"));
			member.setAddress(rs.getString("address"));
			member.setTel(rs.getString("tel"));
			member.setReg_date(rs.getDate("reg_date"));
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return member;
		
	}
	
	// 4-2. 회원수정 : DB Connection 후 조회 후 수정(update Method)
	public int update(Member2 member) throws SQLException {
		
		Connection conn = getConnection();
		
		String sql = "update member2 set passwd=?, name=?, address=?, tel=? where id=?";
		System.out.println("getId->"+member.getId());
		System.out.println("getName->"+member.getName());
		System.out.println("getAddress->"+member.getAddress());
		System.out.println("getTel->"+member.getTel());
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getPasswd());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getTel());
		pstmt.setString(5, member.getId());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
		
	}
	
	// 5. 회원삭제 : DB Connection 후 삭제 (delete Method)
	public int delete(String id, String passwd) throws SQLException {
		
		Connection conn = getConnection();
		
		String sql = "delete from member2 where id=? and passwd=?";
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
}
