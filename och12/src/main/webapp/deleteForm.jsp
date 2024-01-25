<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="memberCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제(회원탈퇴) 폼</title>
</head>
<body>

	<h2>탈퇴하려면 암호를 입력하세요.</h2>
	
	<form action="deletePro.jsp">
	
		<fieldset>
		
			<label for="passwd">암호 : </label>
			<input type="password" name="passwd" id="passwd"><p>
			<input type="submit" value="OK">
		
		</fieldset>
	
	</form>

</body>
</html>