<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] winner = {"승자1", "승자2","승자3"};

	request.setAttribute("winner", winner);
	
	RequestDispatcher rd = request.getRequestDispatcher("winnerResult.jsp");
	
	rd.forward(request, response);
%>
</body>
</html>