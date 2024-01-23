<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>부서 정보 수정</h2>
	
	<form action="oraUpdate.jsp">
		
		<!-- primary key : hidden : 수정 불가. pk를 건드리면 데이터 무결성이 깨지기 때문 -->
		부서 코드 : ${deptno }<p>
		<input type="hidden" name="deptno" value="${deptno }">
		
		부서명 : <input type="text" name="dname" value="${dname }"><p>
		근무지 : <input type="text" name="loc" value="${loc }"><p>
		<input type="submit" value="OK">
		
	</form>

</body>
</html>