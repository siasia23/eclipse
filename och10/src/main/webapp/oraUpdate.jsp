<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="dbError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>scriptlet + preparedStatement 사용한 DB Update</h2>
	
	<%
	
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		
		String sql = "update dept set dname=?, loc=? where deptno=?";
		System.out.println("sql : " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dname);
		pstmt.setString(2, loc);
		pstmt.setString(3, deptno);
		
		int result = pstmt.executeUpdate();
		
		if (result > 0) out.println("updated!!");
		else 				out.println("failed..");
		
		pstmt.close();
		conn.close();
		
	%>

</body>
</html>