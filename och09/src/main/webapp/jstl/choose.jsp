<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>인사말 Switch 유사</h2>
		
	<!-- c:choose 태그 안에 주석 넣으면, 주석도 태그로 인식해버려서 500 에러 뜸 -->	
	<!-- num2.html의 form에서 파라미터 num1 받아오니까 param.num1로 받아오기 -->
	
	<c:choose>
		<c:when test="${param.num1==0 }">하이</c:when>
		<c:when test="${param.num1==1 }">ㅇㅇ</c:when>
		<c:when test="${param.num1==2 }">커피커피</c:when>
		<c:otherwise>누구냐</c:otherwise>
	</c:choose>
	
	
	

</body>
</html>