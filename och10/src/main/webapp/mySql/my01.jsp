<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySQL 연결하기</title>
</head>
<body>
<%

	String driver = "com.mysql.cj.jdbc.Driver" ;
	String url    = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, "root", "mysql80!@#");
	
	if (conn != null) out.println("mysql 연결 성공");
	else out.println("연결 실패");
	
	conn.close();
	
%>
</body>
</html>