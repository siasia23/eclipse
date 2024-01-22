<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt:formatNumber</title>
</head>
<body>

	<!-- groupingUsed : 숫자를 3자리 단위로 자동으로 콤마 삽입 -->
	<fmt:formatNumber value="1000000" 			groupingUsed="true"/><br>
	
	<!-- 소수점 자리수 표현 -->
	<fmt:formatNumber value="3.1415923" 			pattern="#.###"/><br>
	<fmt:formatNumber value="3.1"					pattern="#.##"/><br>
	<fmt:formatNumber value="3.1" 					pattern="#.00"/><br>
	<fmt:formatNumber value="12143432453." 	pattern="#,###.00"/><br>
	
	<!-- currencySymbol : 통화 종류 -->
	<fmt:formatNumber value="250000" 				type="currency" 		currencySymbol="\\"/><br>
	
	<!-- 퍼센트로 표현 -->
	<fmt:formatNumber value="0.75" 					type="percent"/><br>

</body>
</html>