<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	MemberDao md = MemberDao.getInstance();
	
	// 과제 2
	int result = md.check(id, passwd);
	
	if (result == 1) {
		
		session.setAttribute("id", id);
		response.sendRedirect("main.jsp");
		
	} else if (result == 0) {
		
%>

	<script type="text/javascript">
		alert("암호 모름");
		history.go(-1);
	</script>

<%} else { %>

	<script type="text/javascript">
		alert("User 존재하지 않음");
		history.go(-1);
	</script>

<%} %>

</body>
</html>