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

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	
	// session은 JSP의 내장객체
	// session.setAttribute() : session의 parameter 설정
	session.setAttribute("id", id);
	session.setAttribute("password", password);
	session.setAttribute("name", name);

%>

	<h2>약관 동의</h2>
	---------------------------------------------------------- <BR>
	1. 회원 정보는 웹 사이트의 운영을 위해서만 사용됩니다.     <BR>
	2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다. <BR>
	----------------------------------------------------------- <BR>
	
	<form action="subscribe.jsp">
	
		<!-- radio button은 name은 동일하고, value에 해당하는 값으로 구분됨 -->
		<!-- 즉, name을 parameter로 받고, 각 value로 구별함 -->
		동의 <input type="radio" name="agree" value="y"><p>
		거부 <input type="radio" name="agree" value="n"><p>
		
		<input type="submit" value="OK">
	
	</form>

</body>
</html>