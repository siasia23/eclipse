<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${param.NAME }의 주소는? ${ADDRESS[param.NAME] }<p>
	${ADDRESS["권도엽"] }<p>		<!-- 한글 인식시키려면 [] 안에 "" 쓰고 써야함 -->
	<%-- ${ADDRESS.김동욱 }<p>	<!-- 에러. 한글 인식 못함 --> --%>
</body>
</html>