<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>
<%@page import="och10.Emp"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../dbError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과제 2-완료</title>
</head>
<body>
<%

	String empno = request.getParameter("empno");

	String sql = "select empno, ename, sal, hiredate from emp where empno=" + empno;
	System.out.println("sql : " + sql);
	
	// 1. DBCP 연동
	Context ctx = new InitialContext();
	DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
	Connection conn = ds.getConnection();
	
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);	
	
	// 2. Emp DTO Setter
	Emp emp = new Emp();
	
	if (rs.next()) {
		
		int empnoInt = rs.getInt(1);
		String ename = rs.getString(2);
		int sal = rs.getInt(3);
		Date hiredate = rs.getDate(4);
		
		emp.setEmpno(empnoInt);
		emp.setEname(ename);
		emp.setSal(sal);
		emp.setHiredate(hiredate);
		
		request.setAttribute("emp", emp);
		
	} else out.println("입력한 부서 번호를 확인하세요.");
	
	rs.close();
	stmt.close();
	conn.close();
	
	// 3. oraResult.jsp 연동
	RequestDispatcher rd = request.getRequestDispatcher("oraResult.jsp");
	rd.forward(request, response);
	
%>
</body>
</html>