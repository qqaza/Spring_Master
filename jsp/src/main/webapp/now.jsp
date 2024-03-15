<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib tagdir="/WEB-INF/tags" prefix="my"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>now.jsp</title>
</head>
<body>
<my:myselect></my:myselect>
<h2>시간 알림 서비스</h2>
현재 날짜와 시간은 
	<%=request.getAttribute("today")%>
	<br>
	<b><font color="green">${requestScope.today}</font></b> 
입니다
		<hr>
		<hr>
		<br>클라이언트IP <%= request.getRemoteAddr() %>
		<br>EL ${pageContext.request.remoteAddr }
		<hr>
		<hr>
		<br>클라이언트 브라우저 <%=request.getHeader("User-Agent") %>
		<br> EL ${header["User-Agent"] }
		<hr>
		<hr>
		<br><%= request.getParameter("name") %>
		<br>EL ${param.name }
		<hr>
		<hr>
		<br><%= request.getCookies()[2].getValue()%>
		<br> EL ${cookie.cart.value }
		
		
</body>
</html>