<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="person" class="och08.Person" scope="request"/>
	
	<jsp:setProperty property="*" name="person"/>
	
	<h1>인적사항</h1>
	
	이름 : <jsp:getProperty property="name" name="person"/><p>
	성별 : <jsp:getProperty property="gender" name="person"/><p>
	나이 : <jsp:getProperty property="age" name="person"/><p>

</body>
</html>