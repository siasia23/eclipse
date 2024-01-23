<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PreparedStatement 객체로 쿼리문 생성</title>
</head>
<body>
<%

	// 파라미터 받아오기
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	// DB 연동
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	// 쿼리문 작성
	// 이 때 ?는 각각 index 가짐(1부터)
	String sql = "insert into dept values (?, ?, ?)";
	
	// 작성한 쿼리문을 콘솔에 찍어보자
	System.out.println("sql : " + sql);
	
	// 드라이버 로드
	Class.forName(driver);
		
	// DB 연동
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
	// PreparedStatement 객체 생성
	// 보안 중요하면 prepareStatement()
	// ********* 이 때 (sql) 들어감!!!! prepare 해야하니까!! ***********
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	// 쿼리문 ?에 index로 각각 값 넣어주기
	pstmt.setInt(1, deptno);
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	
	// executeUpdate()는 int로 받음
	// ********* (sql)을 위에서 넣어줬으니까 여기서는 안 넣음!! ***********
	int result = pstmt.executeUpdate();
	
	// 작업 결과 화면에 뿌리기
	if (result > 0) 	out.println("입력 성공!");
	else				out.println("입력 실패ㅠ");
		
	// 닫기
	pstmt.close();
	conn.close();
	
%>
</body>
</html>