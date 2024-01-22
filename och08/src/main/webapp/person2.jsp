<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 
	<!-- Person person = new Person(); -->
	<jsp:useBean id="person" class="och08.Person" scope="request"/>
	
	<!-- person.setName("ㅇㅇㅇ"); -->
	<jsp:setProperty property="*" name="person"/>
	
	<!-- person.getName(); -->
	이름 : <jsp:getProperty property="name" 	name="person"/><p>
	성별 : <jsp:getProperty property="gender" 	name="person"/><p>
	나이 : <jsp:getProperty property="age" 		name="person"/><p>
	 --%>
	 
	<!-- 페이지 이동 -->
	<!-- RequestDispatcher rd = request.getRequestDispatcher("personResult.jsp"); -->
	<!-- rd.forward(request, response); -->
	<jsp:forward page="personResult.jsp"/>

</body>
</html>