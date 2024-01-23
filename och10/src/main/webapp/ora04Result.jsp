<%@page import="och10.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Expression 쓰려면 아래꺼 필요함 -->
	<%
		Dept dept = (Dept) request.getAttribute("dept");
	%>

	<!-- 자바 코드니까 getter로 호출 -->
	<h2>Expression 부서정보</h2>
	부서코드 : <%=dept.getDepno() %><p>
	부서명 :  <%=dept.getDname() %><p>
	근무지 :  <%=dept.getLoc() %><p>
	
	<%-- <!-- EL이니까 파라미터명으로 바로 호출 -->
	<h2>EL 표기법 부서정보</h2>	
	부서코드 : ${dept.deptno }<p>
	부서명 : ${dept.dname }<p>
	근무지 : ${dept.loc } --%>

</body>
</html>