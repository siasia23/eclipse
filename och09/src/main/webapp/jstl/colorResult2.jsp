<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이중 향상형 for문을 써보자</title>
</head>
<body>

	<!-- for (cnt=1; cnt <= 7; cnt++) -->
	<c:forEach var="cnt" begin="1" end="7" step="1">
	
		<c:forEach var="col" items="${color }">
				<font color="${col }" size="${cnt }">야호!</font>
		</c:forEach>

		<br>

	</c:forEach>

</body>
</html>