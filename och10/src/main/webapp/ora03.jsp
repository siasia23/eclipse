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
<title>Insert title here</title>
</head>
<body>
<%

	String deptno = request.getParameter("deptno");
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	String sql = "select * from dept where deptno=" + deptno;
	System.out.println("sql : " + sql);
	
	Class.forName(driver);
	
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
	Statement stmt = conn.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	if (rs.next()) {
		
		String dname = rs.getString("dname");
		String loc = rs.getString(3);
		
		out.println("부서코드 : " + deptno + "<p>");
		out.println("부서명 : " + dname + "<p>");
		out.println("근무지 : " + loc + "<p>");
		
		request.setAttribute("deptno", deptno);
		request.setAttribute("dname", dname);
		request.setAttribute("loc", loc);
		
	} else out.println("존재하지 않는 부서임");
	
	rs.close();
	stmt.close();
	conn.close();
	
	RequestDispatcher rd = request.getRequestDispatcher("ora03Result.jsp");
	rd.forward(request, response);
	
%>
</body>
</html>