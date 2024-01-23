<%@page import="och10.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Model 1</title>

<style type="text/css">
	tr:hover {
		background-color: red;
	}
</style>

</head>
<body>

	<h2>Model 1 View</h2>
	
	<%
		ArrayList<Emp> al = (ArrayList<Emp>) request.getAttribute("al");
	
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
	%>
	
	<table width="100%" bgcolor="yellow" border="1">
	
		<!-- tr : row, th : cell -->
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>업무</th>
			<th>급여</th>
		</tr>
		
		<%
			// al.size = al에 들어간 row의 개수. 여기서는 14
			for(int i=0; i < al.size(); i++) {
				
				out.println("<tr><td>" + al.get(i).getEmpno() + "</td>");
				out.println("<td>" + al.get(i).getEname() + "</td>");
				out.println("<td>" + al.get(i).getJob() + "</td>");
				out.println("<td>" + al.get(i).getSal() + "</td></tr>");
				
			}
		%>
	
	</table>

</body>
</html>