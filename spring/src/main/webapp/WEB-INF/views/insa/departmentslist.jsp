<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>부서목록</h3>
	
	<c:forEach items="${departmentsList }" var="departs">
	<div style="border: 1px solid blue;">
	id<span>${departs.departmentId}</span>
	이름<span>${departs.depaermentName}</span>
	매니져id<span>${departs.managerId}</span>
	<span>${departs.locationId}</span>
	</div>
	
	</c:forEach>
</body>
</html>