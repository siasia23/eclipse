<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="dbError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과제2 완료</title>
</head>
<body>

	<!-- 과제2 -->

	<h2>scriptlet + Statement 사용해서 부서 삭제</h2>

<%

	// deptno를 String으로 받아도 됨
	int deptno = Integer.parseInt(request.getParameter("deptno"));

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	String sql = "delete dept where deptno=" + deptno;
	System.out.println("sql : " + sql);
	
	Class.forName(driver);
	
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
	Statement stmt = conn.createStatement();
	
	int result = stmt.executeUpdate(sql);
	if (result > 0) out.println("삭제 완료!");
	
	stmt.close();
	conn.close();

%>
</body>
</html>