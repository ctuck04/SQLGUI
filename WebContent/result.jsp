<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<thead>
			<tr>
			<c:forEach items="${headers}" var="column">
				<th>${column}</th>
			</c:forEach>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="row">
		  		<tr>
			        <c:forEach items="${row}" var="value">	
			    	<td>${value}</td>
			    	</c:forEach>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>