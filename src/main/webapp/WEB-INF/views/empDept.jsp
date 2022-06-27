<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
 		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>부서</td>
			<td>위치</td>			
		</tr> 
		<c:forEach items="${empDeptList}" var="deptList">
			 <c:forEach items="${deptList.empList}" var="emp">
				<tr>			
	 				<td>${emp.empno}</td>
					<td>${emp.ename}</td> 
					<td>${deptList.dname}</td>
					<td>${deptList.loc}</td>
				</tr>
		 	</c:forEach> 
		</c:forEach>


	</table>
</body>
</html>