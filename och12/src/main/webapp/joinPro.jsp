<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 프로세스</title>
</head>
<body>

	<!-- member2 = new Member2(); -->
	<!-- DTO : och12.Member2 -->
	<jsp:useBean id="member2" class="och12.Member2"/>
	
	<jsp:setProperty property="*" name="member2"/>

	<%
		MemberDao md = MemberDao.getInstance();
	
		// 과제 3
		int result = md.insert(member2);
		
		if (result > 0) {
	%>
		<script type="text/javascript">
			alert("회원가입 ㅊㅋ");
			location.href = "loginForm.jsp";
		</script>
	<%
		} else { %>
			<script type="text/javascript">
				alert("회원가입 실패");
				location.href = "joinForm.jsp";
			</script>
	<%} %>

</body>
</html>