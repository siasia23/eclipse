<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>oracle 연동하기</title>
</head>
<body>
<%

	// oracle driver
	String driver = "oracle.jdbc.driver.OracleDriver";

	// jdbc:oracle:thin: (예약어니까 그대로 쓰기)
	// @IP:PORT number:SID
		// IP : DB를 갖고 있는 IP주소
		// PORT : DB의 포트 번호
		// SID = service ID
		// SID 모를 때 찾을 경로 : C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN\tnsnames.ora
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	// 메모리에 JDBC driver 로드
	Class.forName(driver);
	
	// DB 연결
	// oracle user : scott, pw : tiger
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
		if (conn != null) 	out.println("연결 성공!!");
		else					out.println("연결 실패ㅠ");
	
	conn.close();
	
%>
</body>
</html>