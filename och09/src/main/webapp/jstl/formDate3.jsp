<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt:formatDate 시간 정보 표기 형식</title>
</head>

	<c:set var="date" value="<%=new Date() %>"/>

<body>

	날짜 : <fmt:formatDate value="${date }" type="date" pattern="YYYY/MM/dd (E)"/><p>	<!-- E : 요일 -->
	시간 : <fmt:formatDate value="${date }" type="time" pattern="hh:mm:ss (a)"/><p>		<!-- a : am -->

</body>
</html>