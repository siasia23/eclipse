<!-- 이 파일은 에러페이지임 : isErrorPage="true" -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
<!-- 이 파일은 에러페이지이지만 이 파일 자체에 에러는 없음 : 정상 상태값 200 -->
<% response.setStatus(200); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>공지</h2>
	
	더 나은 서비스를 위해 준비중입니다<p>
	메세지 : <%=exception.getMessage() %><p>
	클래스 : <%=exception.getClass() %>
	
</body>
</html>