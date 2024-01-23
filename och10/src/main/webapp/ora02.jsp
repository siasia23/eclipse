<%@page import="och10.Dept"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과제1 완료</title>
</head>
<body>
<%

	// 과제 1.
	// 조건 1. 부서번호(deptno) 가지고 dept 테이블 조회. createStatement 사용.
	
	int deptno = Integer.parseInt(request.getParameter("deptno"));

	// DB 연동
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	// 쿼리문 작성
	String sql = "select * from dept where deptno=" + deptno;
	
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
	Statement stmt = conn.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	// *** primary key 특징 : unique, not null, 최소성 *****
	// 여기서 deptno는 pk니까 while 말고 if문으로 써도 됨
	while (rs.next()) {
		
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
		
		out.println("부서번호 : " + deptno + "<p>");
		out.println("부서명 : " + dname + "<p>");
		out.println("위치 : " + loc);
		
		if (! rs.next()) break;
		
	}
	
	rs.close();
	stmt.close();
	conn.close();
	
%>
</body>
</html>