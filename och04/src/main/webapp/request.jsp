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

	String protocol = request.getProtocol();
	String server = request.getServerName();
	int port = request.getServerPort();
	String clientIP = request.getRemoteAddr();
	String clientHost = request.getRemoteHost();
	String methodType = request.getMethod();
	String url = new String(request.getRequestURL());
	String uri = request.getRequestURI();
	String contextPath = request.getContextPath();	// 자주 씀!! 기억해두기!

%>

	<h2>Request 내장 객체 예제 2</h2>
	
	프로토콜명 : <%=protocol %><p>
	접속한 서버명 : <%=server %><p>
	접속한 서버의 포트 번호 : <%=port %><p>
	클라이언트의 IP : <%=clientIP %><p>
	클라이언트의 호스트명 : <%=clientHost %><p>
	현재 페이지의 method 방식 : <%=methodType %><p>
	요청한 현재 페이지의 경로(URL) : <%=url %><p>
	요청한 현재 페이지의 경로(URI) : <%=uri %><p>
	웹 어플리케이션에서의 컨텍스트 경로 : <%=contextPath %><p>

</body>
</html>