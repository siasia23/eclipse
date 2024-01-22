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

	String[] col = {"red","orange","yellow","green","blue","navy","violet","black"};

	// n은 8 미만의 랜덤 정수 (0 포함)
	int n = (int) (Math.random() * 8);
	
	// pgm 결과값은 다음 셋 중 하나가 됨 : color1.jsp, gugu1.jsp, response.jsp
	String pgm = request.getParameter("pgm") + ".jsp";
	
	// 1. form 없이 이동할 페이지를(문서를, 파일을) 지정하는 객체 선언
	RequestDispatcher rd = request.getRequestDispatcher(pgm);
	
		// 페이지 이동시키기 전에 if문으로 파라미터를 넣어줌
		if (pgm.equals("color1.jsp")) {	// 배경을 누르면 color1.jsp로 이동
			
			// 변수 선언
			request.setAttribute("color", col[n]);	// setAttribute : form을 통하지 않고 파라미터를 넘기는 메소드
			// rd = request.getRequestDispatcher("color1.jsp");
		
		} else if (pgm.equals("gugu1.jsp")) {		// 구구단을 누르면 gugu1.jsp로 이동
			
			// 2단 ~ 9단
			request.setAttribute("num", n+2);
			// rd = request.getRequestDispatcher("gugu1.jsp");
			
		} else if (pgm.equals("response.jsp")) {		// 중앙정보를 누르면 response.jsp로 이동
			// 예비
		}
		
	// 2. 파라미터 받았으니, 이제 페이지 이동시키기
	rd.forward(request, response);

%>
</body>
</html>