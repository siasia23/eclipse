<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	table {background-color: pink;}
	tr {font-size: 24;}
</style>

</head>
<body>

	<h2>로그인</h2>
	
	<form action="loginPro.jsp" method="post">
	
		<table border="1">
		
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			
			<tr>
				<td>PW</td>
				<td><input type="password" name="passwd" required="required"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="OK"></td>
				<td><input type="reset" value="Cancle"></td>
			</tr>
		
		</table>
	
	</form>

</body>
</html>