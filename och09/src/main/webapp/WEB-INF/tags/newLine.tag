<%@ tag language="java" pageEncoding="UTF-8"%>

<!-- 이 페이지의 바디는 비워두겠다. -->
<%@ tag body-content="empty" %>

<!-- 이 태그 쓰면 입력받도록 할 속성들 -->
<%@ attribute name="color" required="true" %>
<%@ attribute name="size"  required="true" type="java.lang.Integer" %>

<font color="${color }">
	<%
		for (int i=0; i<size; i++) {
			out.println("-");
		}
	%>
</font>
