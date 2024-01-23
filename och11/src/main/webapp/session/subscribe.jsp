<%@page import="och11.MemberDao"%>
<%@page import="och11.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="dbError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	String chk = "";
	String agree = request.getParameter("agree");
	
	// parameter = agree
	// value = y
	if (agree.equals("y")) {
		
		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");
		String name = (String) session.getAttribute("name");
		
		System.out.println("Subscribe ID : " + id);
		System.out.println("Subscribe PW : " + password);
		System.out.println("Subscribe Name : " + name);
		
		// 과제 1
		// 1. MemberDTO setting
		MemberDto member = new MemberDto();
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		// 2. memberDAO Insert
		MemberDao md = new MemberDao();
		
		int result = md.insert(member);
		
		if (result > 0) chk = "success";
		else				chk = "fail";
		
	} else chk = "fail";
	
	// invalidate() : session 무효화. 화면 전체를 재표시하라
	session.invalidate();
	
	out.print("invalidate() 적용 후에도 " + session.getId() + "<br>");
	
	// 페이지 이동하는 방법 중 하나
	response.sendRedirect("result.jsp?chk=" + chk);

%>
</body>
</html>