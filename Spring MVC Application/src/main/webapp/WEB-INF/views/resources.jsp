<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>


<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	
		<div class="container">
		
		<h2>Resources</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Name</th><th>Type</th><th>Cost</th>
				</tr>
				<c:forEach items="${resources}" var="resource" >
					<tr>
						<td><a href="<spring:url value="/resource/${resource.resourceId}"></spring:url>">${resource.name}</a> </td>
						<td>${resource.type}</td>
						<td>${resource.cost}</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	
	
	
	
	
</body>
</html>