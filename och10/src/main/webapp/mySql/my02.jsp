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
<title>MySQL로 데이터 조회</title>
</head>
<body>
<%

	String dno = request.getParameter("dno");

	String driver = "com.mysql.cj.jdbc.Driver" ;
	// MySQL PORT number : 3306
	// 생성한 user name : scottdb
	String url    = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, "root", "mysql80!@#");
	
	String sql = "select * from division where dno=" + dno;
	System.out.println("sql : " + sql);
	
	Statement stmt = conn.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	if (rs.next()) {
		
		String dname = rs.getString(2);
		String phone = rs.getString(3);
		String position = rs.getString(4);
		
		out.println("부서 코드 : " + dno + "<p>");
		out.println("부서명 : " + dname + "<p>");
		out.println("전화번호 : " + phone + "<p>");
		out.println("직급 : " + position + "<p>");
		
	} else out.println("존재하지 않는 부서임");
	
	rs.close();
	stmt.close();
	conn.close();
	
%>
</body>
</html>