<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project manager</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			
				<div class="form-group">
					<label for="project-name">Name</label>
					<span>${project.name}</span>
				</div>

				<div class="form-group">
					<label for="project_type">Type</label>
					<span>${project.type }</span>
				</div>
							
				<div class="form-group">
					<label for="sponsor">Sponsor</label>
					<span>${project.sponsor}</span>
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<span>${project.authorizedFunds}</span>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<span>${project.authorizedHours}</span>
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<span>${project.description}</span>
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					<span>${project.special == true ? 'Yes':'No'}</span>
				</div>
			
		</div>
	</div>
	
</body>
</html>