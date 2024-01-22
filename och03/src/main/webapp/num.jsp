<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 스크립틀릿 위치는 익스프레션 위에 있기만 하면 됨. 헤드 위에 쓸지 아래에 쓸지 상관 없음 -->
<%
	// parameter 받고 num만큼 누적
	
	int num = Integer.parseInt(request.getParameter("num"));
	
	int sum = 0;
	
	for (int i=0; i <= num; i++) {
		sum += i;
	}
		
%>
</head>

<body>
	<!-- 보여주기 -->
	<h1>1부터 <%=num %>까지 합</h1>
	<%=sum %>
</body>
</html>