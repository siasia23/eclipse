<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>1부터 100까지의 합 (scriptlet + expression)</h2>
	
	<!-- scriptlet -->
	<%
		int sum = Integer.parseInt(request.getAttribute("sum").toString());
	%>
	
	<!-- expression -->
	<%=sum %><p>

</body>
</html>