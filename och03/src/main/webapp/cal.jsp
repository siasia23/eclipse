<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사칙연산</title>
</head>
<body>

	<%
	// 스크립틀릿(scriptlet) : JAVA 코드로 작성
	
	int num1 = Integer.parseInt(request.getParameter("num1")) ;
	int num2 = Integer.parseInt(request.getParameter("num2")) ;
	
	%>
	
	<!-- Expression(표현식) -->
	
	<h1>사칙연산</h1>
	덧셈 : <%=num1 + num2 %><p>
	뺄셈 : <%=num1 - num2 %><p>
	곱셈 : <%=num1 * num2 %><p>
	나눗셈 : <%=num1 / num2 %><p>
	
</body>
</html>