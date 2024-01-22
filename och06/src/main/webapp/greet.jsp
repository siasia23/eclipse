<%@page import="java.io.FileWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	private PrintWriter pw;
	String date;
	
	public void jspInit() {
		
		System.out.println("jspInit() started!");

		GregorianCalendar gc = new GregorianCalendar();
	
		date = String.format("%TF %TT", gc, gc);
		
		System.out.println("date : " + date);
		
		String fileName = "c:/log/" + date.replaceAll(":", "") + ".txt";	// replaceAll(a,b) : a를 모두 b로 바꾼다
																								// 파일명에 콜론 못 넣어서 없애주는거
		
		try {
			
			pw = new PrintWriter(new FileWriter(fileName, true));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
%>
<%
	String name = request.getParameter("name");
	String msg = name + "님 반가움";
	
	out.println(msg + "<p>현재시간 : " + date);				// 화면에 프린트
	pw.println(msg + "\r\n 현재시간 : " + date + "\r\n");	// 파일에 프린트
%>
<%!
	public void jspDestroy() {
		
		System.out.println("jspDestroy() started!");
		
		pw.flush();		// 파일로 buffer 데이터 쏘기
		
		if (pw != null) pw.close();

	}
%>
</body>
</html>