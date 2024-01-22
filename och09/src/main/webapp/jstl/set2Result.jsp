<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>상품정보</h2>
	
	<!-- 이 페이지를 호출한 set2.jsp가 변수 scope를 request로 해둬서 여기서 바로 EL 표기법으로 파라미터 사용 가능 -->
	
	코드 : ${code }<p>
	이름 : ${name }<p>
	가격 : ${price }<p>
	
</body>
</html>