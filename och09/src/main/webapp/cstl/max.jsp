<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custom tag 써보기 - max.tag</title>
</head>
<body>

	<h2>큰 수 찾기</h2>
	
	<u:max num2="33" num1="75"/>
	둘 중에 큰 값 : ${maximum }

</body>
</html>