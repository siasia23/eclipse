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

	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	// DB에 이 데이터가 있다고 가정해보자
	// 아래 a 태그의 당첨자 보기 페이지로 이동하기 위해 id, pw 확인하는것
	if (id.equals("kk") && pass.equals("1234")) {
		
		session.setAttribute("id", id);
		
	} else session.invalidate();

%>

<a href="sub2/winner.jsp">당첨자 보기</a>

</body>
</html>