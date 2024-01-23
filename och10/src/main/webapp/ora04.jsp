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
<title>DTO로 접근하기</title>
</head>
<body>

	<!-- DTO : Data Transfer Object -->
	<!-- DAO : Data Access Object (DML 로직) -->
	
<%

	String deptno = request.getParameter("deptno");

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	String sql = "select * from dept where deptno=" + deptno;
	System.out.println("sql : " + sql);
	
	Class.forName(driver);
	
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
	Statement stmt = conn.createStatement();
	
	// select문은 ResultSet으로 받는다
	ResultSet rs = stmt.executeQuery(sql);
	
	// DTO
	Dept dept = new Dept();
	
	// deptno가 primary key라서 값이 중복되지 않으니까 while문 안 쓰고 if 씀
	if (rs.next()) {
		
		int deptnoInt = rs.getInt(1);
		String dname = rs.getString("dname");	// rs.getString(2);
		String loc = rs.getString(3);	// 숫자는 조회되는 컬럼 순서
		
		out.println("부서코드 : " + deptno + "<p>");
		out.println("부서명 : " + dname + "<p>");
		out.println("근무지 : " + loc + "<p>");
		
		// Dept Setting (DTO의 setter 이용)
		dept.setDepno(deptnoInt);	// dept.setDepno(Integer.parseInt(deptno));
		dept.setDname(dname);
		dept.setLoc(loc);
		
		// Dept(DTO)로 저장
		request.setAttribute("dept", dept);
		
	} else out.println("해당 부서는 존재하지 않음");
	
	rs.close();
	stmt.close();
	conn.close();
	
	RequestDispatcher rd = request.getRequestDispatcher("ora04Result.jsp");
	rd.forward(request, response);
		
%>

</body>
</html>