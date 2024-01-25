<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 시 아이디 존재 여부 확인</title>

<%	String id = request.getParameter("id"); %>

<script type="text/javascript">

	function wincl() {
		
		opener.document.frm.id.value = "<%=id%>";
		
		// 창 닫기
		window.close();
		
	}

</script>

</head>
<body>

<%

	MemberDao md = MemberDao.getInstance();

	// 과제 3. confirm() 완성. check()와 유사
	int result = md.confirm(id);
	
	// 존재하지 않는 사용자면,
	if (result == 0) {
	
%>

	<%=id %>는 사용할 수 있습니다.<p>
	<input type="button" value="닫기" onclick="wincl()">
	
<%

	// 존재하는 사용자면,
	} else { %>
	
	<%=id %>는 이미 존재합니다. 새로 입력하세요.<p>
	
	<form>
	
		아이디 : <input type="text" name="id"><p>
		<input type="submit" value="OK">
	
	</form>

<%} %>

</body>
</html>