<%@page import="java.util.HashMap"%>
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
	HashMap<String, String> map = new HashMap<String, String>();

	map.put("Park", "목동");
	map.put("권도엽", "신촌");
	map.put("김동욱", "홍대");
	map.put("김지훈", "시드니");
	
	request.setAttribute("ADDRESS", map);		// ***Call By Reference : 파라미터의 값을 직접 전달하지 않고 참조값만 넘김
																// ***Call By Value : 파라미터의 값을 직접 전달
																// 면접 단골 문제이니, 둘의 차이 잘 알아두기!!
	
	RequestDispatcher rd = request.getRequestDispatcher("mapView.jsp?NAME=Park");		// ?파라미터명=파라미터값
	
	rd.forward(request, response);
%>
</body>
</html>