<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>form으로 보낸 파라미터는 param.xx로 받음</h1>
	첫번째 동물 : ${param.an1 }<br>
	두번째 동물 : ${param.an2 }<p>
	같은 동물 : ${param.an1 == param.an2 }<br>
	
</body>
</html>