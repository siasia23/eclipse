<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>연산결과 setting(web.xml) 통한 에러 처리</h2>
	
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		out.println(num1 + "+" + num2 + "=" + (num1+num2) + "<p>");
		out.println(num1 + "-" + num2 + "=" + (num1-num2) + "<p>");
		out.println(num1 + "*" + num2 + "=" + (num1*num2) + "<p>");
		out.println(num1 + "/" + num2 + "=" + (num1/num2) + "<p>");
	%>
	
</body>
</html>