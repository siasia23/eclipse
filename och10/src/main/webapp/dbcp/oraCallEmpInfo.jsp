<%@page import="java.sql.Types"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
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

	int empno = Integer.parseInt(request.getParameter("empno"));
	System.out.println("empno : " + empno);
	
	// 오라클 DB 연동
	Context ctx = new InitialContext();
	DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
	Connection conn = ds.getConnection();
	
	// Procedure 호출 쿼리
	String sql = "{call Emp_Info3(?, ?)}";		// {call 프로시저명(파라미터1, 파라미터2, ...)}
	System.out.println("sql : " + sql);
	
	// Procedure Call 할 때 쓰는 객체 : CallableStatement
	CallableStatement cs = conn.prepareCall(sql);
	
	// 사번
	// setInt : setting. IN type parameter 값 설정
	cs.setInt(1, empno);
	
	// 급여
	// registerOutParameter :getting returned. OUT type parameter 값 설정
	cs.registerOutParameter(2, Types.DOUBLE);
	
	// 쿼리문 전송
	cs.execute();
	
	out.println("급여 : " + cs.getDouble(2));
	
	cs.close();
	conn.close();

%>
</body>
</html>