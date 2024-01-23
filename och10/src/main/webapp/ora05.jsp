<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="och10.Emp"%>
<%@page import="java.util.ArrayList"%>
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
	// DB 연동
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	String sql = "select empno, ename, job, sal from emp";
	System.out.println("sql : " + sql);
	
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
	// 데이터를 ArrayList로 받아오자
	// ArrayList 하나에 들어가는 데이터 = 1 row
	ArrayList<Emp> al = new ArrayList<Emp>();
	
	Statement stmt = conn.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
/*	DB에서 조회한 해당 데이터

	7369	SMITH	CLERK		800
	7499	ALLEN	SALESMAN	1600
	7521	WARD	SALESMAN	1250
	7566	JONES	MANAGER	2975
	7654	MARTIN	SALESMAN	1250
	7698	BLAKE	MANAGER	2850
	7782	CLARK	MANAGER	2450
	7788	SCOTT	ANALYST	3000
	7839	KING		PRESIDENT	5000
	7844	TURNER	SALESMAN	1500
	7876	ADAMS	CLERK		1100
	7900	JAMES	CLERK		950
	7902	FORD		ANALYST	3000
	7934	MILLER	CLERK		1300
*/
	
	if (rs.next()) {
		
		// do-while문
/*		
		while(조건) {실행문} 
		조건 먼저 판별하고, 그 결과가 true일때 실행문 계속 ㄱ. false면 멈춤

		do {실행문} while(조건)
		일단 무조건 실행하고, 조건 판별해서, true면 계속 실행. false면 멈춤.
*/		
		do {
		
			Emp emp = new Emp();
			
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSal(rs.getInt(4));
			
			al.add(emp);
			
		} while (rs.next());
		
		request.setAttribute("al", al);
		
		rs.close();
		stmt.close();
		conn.close();
		
//		RequestDispatcher rd = request.getRequestDispatcher("ora05Result.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("ora05Result2.jsp");
		
		rd.forward(request, response);
		
	} else {
		
		out.println("데이터가 없어용");
		stmt.close();
		conn.close();
		
	}
	
%>
</body>
</html>