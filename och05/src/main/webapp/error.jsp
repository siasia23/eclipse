<!-- 지시자에 이것은 에러 페이지임을 선언함 : isErrorPage="true" -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
<!DOCTYPE html>
<html>
<%
	// HTTP 코드 상태를 정상(200)으로 설정함.
	// 에러 메시지에 비정상 코드가 묻어올 가능성 있어서?
	response.setStatus(200);
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항</h1>
	작업중...<p>
</body>
</html>