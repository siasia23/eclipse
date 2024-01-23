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

	String dno = request.getParameter("dno");
	
	String driver = "com.mysql.cj.jdbc.Driver" ;
	String url    = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, "root", "mysql80!@#");
	
	String sql = "select * from division where dno=" + dno;
	System.out.println("sql : " + sql);
	
	Statement stmt = conn.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	if (rs.next()) {
		
		request.setAttribute("dno", dno);
		request.setAttribute("dname", rs.getString(2));
		request.setAttribute("phone", rs.getString(3));
		request.setAttribute("position", rs.getString(4));
		
		// 파라미터가 있을 때 페이지 이동시키려고 if문 안으로 넣음
		RequestDispatcher rd = request.getRequestDispatcher("myResult.jsp");
		rd.forward(request, response);
		
		rs.close();
		stmt.close();
		conn.close();
		
	}
	
	stmt.close();
	conn.close();
	
%>

<script type="text/javascript">
	alert("존재하지 않는 부서임");
	location.href = "myUpdate.html";
</script>

</body>
</html>