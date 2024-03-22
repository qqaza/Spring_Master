<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.firstRow{ color : yellowgreen;}
	.oddRow{color : cyan;}
	.backColor {background-color: #eeeeee}
</style>
<script c:inline="javascript">
	//ì°ê¸° í¸íë¤ê³  í¨ ìì§ ìëª¨ë¦
	let emplist = [[${empList}]]
	
	
	function gopage(p){
		frmSearch.page.value = p;
		frmSearch.submit();		
		//location.href= ' empList?page=' + p
	}
	
	//ì´ê¸°í
	function init(){
		frmSearch.departmentId.value=""
		frmSearch.firstName.value=""
		frmSearch.managerId.value=""
			location.href= 'empList'
	}
	
	function move(empId){
		frmSearch.action= '/info/' + empId
		frmSearch.submit();
	}
	</script>
</head>
<body>
<div layout:fragment="content">
	ì¬ìì:<span c:text="${#lists.size(empList)}">10</span>ëª
	íì¬ëª:<span c:utext="${copmpanyName}">...</span>
	
	<!-- ê²ì í¼ ìì -->
	<form name="frmSearch" th:object="${empVo}" action="empList">
	<input type="hidden" name="page"> 
		<select name="departmentId" th:value="*{departmentId}">
		<option value="">ì í
		<option value="10" th:selected="*{departmentId}=='10'">Administration
		<option value="20" th:selected="*{departmentId}=='20'">Marketing
		<option value="50" th:selected="*{departmentId}=='50'">Shipping
		<option value="60" th:selected="*{departmentId}=='60'">IT
		<option value="80" th:selected="*{departmentId}=='80'">Sales
		<option value="90" th:selected="*{departmentId}=='90'">Executive
		<option value="110" th:selected="*{departmentId}=='110'">Accounting
	</select>
		firstName<input name="firstName" th:value="*{firstName}"> <!-- th:objectì ì¤ì íê³  * ë¡ empVo ëì  ì´ë¤ -->
		ManagerId<input name="managerId"th:value="*{managerId}">
		<button type="button" onclick="gopage(1)">ê²ì</button>
		<button type=button onclick="init()">ì´ê¸°í</button>
	</form>
	
	<!-- ê²ì í¼ ë -->
	<table border="1"> 
		<tr>
			<th>No</th>
			<th>employee_id</th>
			<th>NAME</th>
			<th>hire_date</th>
			<th>salary</th>
			<th>ë³´ëì¤</th>
			<th>ìì |ì­ì </th>
			
		</tr>
		<tr th:each="emp, stat : ${empList}">
			<td th:text="${stat.count}" class="backColor" th:classappend="${stat.first? 'firstRow' : stat.odd ? 'oddRow' : _ }">1</td>
			<td th:text="${emp.employeeId}">100</td>
			<!--/* ì±+ì´ë¦ í©ì¹ê¸° 3ê°ì§*/-->
			<td th:text="|${emp.firstName} ${emp.lastName}|">ê¸¸ë</td>
			<!--/*  <td th:text="${emp.firstName} +' ' + ${emp.lastName}">ê¸¸ë</td>
			<td> [[${emp.firstName]]  [[${emp.lastName}]] </td> */-->
			<!--/* ë ì§ ë³í */-->
			<td th:text="${#dates.format(emp.hireDate,'yyyy-MM-dd')}">2010-10-10</td>
			<td th:text="${#numbers.formatDecimal(emp.salary,3,'COMMA',0,'POINT')}">2,000</td>
			<!-- ê¸ì¬ 1ë§ì ê¸°ì¤ì¼ë¡ ì ì²­ ë¯¸ì ì²­ ì¡°ê±´ë¬¸ -->
			<td><button th:if="${emp.salary} < 10000">ì ì²­</button>
			<button th:unless="${emp.salary} < 10000">ë¯¸ì ì²­</button>
			</td>
			<td><!--/*  localhost:8081/update/100  */-->
				<!--  <a th:href="@{/update/{id}(id=${emp.employeeId})}">|ìì |</a>-->
				<button type="button" th:onclick="move([[${emp.employeeId}]])">ì¡°í</button>
				<!--/*  localhost:8081/delete?employeeId=100$$name=xxx */-->
				<a th:href="@{/delete(employeeId=${emp.employeeId},name=${emp.firstName})}">|ì­ì |</a>
			</td>
		</tr>
	</table>
	
<!-- íì´ì§ ìì -->
	<nav aria-label="...">
	  <ul class="pagination">
	    <li class="page-item" th:if="${paging.startPage} > 1">
	        <a class="page-link" th:href="|javascript:gopage(${paging.startPage-1})|">Previous</a></li>

	    <li th:each="num : *{#numbers.sequence(paging.startPage, paging.endPage)}" 
	        class="page-item" 
	        th:addclass="${num} == ${paging.page} ? active">
	        <a class="page-link" th:href="|javascript:gopage(${num})|"  th:text="${num}">2</a></li>
	    
	    <li class="page-item" th:classappend="${paging.endPage} <= ${paging.lastPage} ? disabled">
	        <a class="page-link" th:href="|javascript:gopage(${paging.endPage+1})|">Next</a></li>
	  </ul>
	</nav>
	<!-- íì´ì§ ì¢ë£ -->
	
	<div class="footersector" th:replace="~{footer :: addr}">ì¬ê¸°ì ì½ì</div>
		[[${paging}]]
		
	
	</div>
</body>
</html>