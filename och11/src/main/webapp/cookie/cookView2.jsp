<%@page import="java.net.URLDecoder"%>
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

	Cookie cooks[] = request.getCookies();

	if (cooks != null) {
		
		for (int i=0; i < cooks.length; i++) {
			
			// "name" = key
			if (cooks[i].getName().equals("name")) {
				
				// 앞에서 encode 했으니까 여기서 decode
				out.println("쿠키 값 : " + URLDecoder.decode(cooks[i].getValue(), "utf-8"));
				
			}
			
		}
		
	}

%>
</body>
</html>