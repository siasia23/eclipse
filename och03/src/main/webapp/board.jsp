<!-- import : 지시자(directive) -->
<%@page import="java.io.FileWriter"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 1. 스크립틀립 : JAVA 코드로 화면 출력 -->
<%
	
	// JSP 내장 객체 중 하나 'request'
	request.setCharacterEncoding("utf-8");

	// 파라미터 받아오기
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// 현재 시간
	Date date = new Date();
	
	/* 파일 저장 */
	long fileName = date.getTime();
	String real = application.getRealPath("/WEB-INF/out/" + fileName + ".txt");		// getRealPath : Tomcat Metadata File 저장
	System.out.println(real);		// 생성된 파일 경로를 콘솔에 찍어보자
	
	// 파일 저장할 수 있는 객체
	FileWriter fw = new FileWriter(real);
	
	// 파일 내용
	String msg = "제목 : " + title + "\r\n";		// \r\n : 캐리지 리턴 라인 피드 = 줄바꿈
			msg += "작성자 : " + writer + "\r\n";
			msg += "내용 : " + content + "\r\n";
	
	fw.write(msg);
	fw.close();

	/* 1. 스크립틀립 : JAVA로 화면 출력 */
	// out도 내장객체
	out.println("제목 1 : " + title + "<p>");
	out.println("작성자 1 : " + writer + "<p>");
	//out.println("작성일 1 : " + date + "<p>");
	out.println("내용 1 : " + content + "<p>");
	out.close();

%>

<!-- 2. html 코드로 화면 출력 -->
제목 2 : <%=title %> <p>
작성자 2 : <%=writer %> <p>
내용 2 : <%=content %> <p>

</body>
</html>