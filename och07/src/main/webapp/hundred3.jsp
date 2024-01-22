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

	int sum = 0;

	for (int i=1; i <= 100; i++) {
		sum += i;
	}
	
	request.setAttribute("sum", sum);				// 파라미터 전달 범위가 끝(?)까지
//	pageContext.setAttribute("sum", sum);		// 파라미터 전달 범위가 페이지
	
	RequestDispatcher rd = request.getRequestDispatcher("hunResultEL3.jsp");
	
	rd.forward(request, response);
	
%>
같은 페이지 : ${sum }
</body>
</html>