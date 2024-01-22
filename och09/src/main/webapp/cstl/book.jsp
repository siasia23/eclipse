<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- tagdir : custom tag 삽입 -->    
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custom tag 써보기 - newLine.tag</title>
</head>
<body>

	<h2>좋아하는 책?</h2>
	
	<u:newLine color="red" size="23"/><p>
	홍길동전<p>
	흥부놀부<p>
	콩쥐팥쥐<p>
	<u:newLine color="blue" size="27"/>

</body>
</html>