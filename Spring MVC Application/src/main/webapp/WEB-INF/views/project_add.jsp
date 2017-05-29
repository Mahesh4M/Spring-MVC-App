<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
			<spring:url value="/project/add" var="addUrl"/>
			<form:form action="${addUrl}" method="post" modelAttribute="project" class="col-md-8 col-md-offset-2">
			
				<div class="form-group">
					<label for="project-name">Name</label>
					<input type="text" id="project-name" 
							class="form-control" name="name"/>
					<form:errors path="name" />		
				</div>

				<div class="form-group">
					<label for="project_type">Type</label>
					<form:select path="type" items="${types}" class="selectpicker">
					</form:select>
				</div>
							
				<div class="form-group">
					<form:label for="sponsor-name" path="">Sponsor Name</form:label>
					<form:input id="sponsor-name" 
							cssClass="form-control" path="sponsor.name"/>
				</div>
				<div class="form-group">
					<form:label for="sponsor-phone" path="">Sponsor Phone</form:label>
					<form:input id="sponsor-phone"
							cssClass="form-control" path="sponsor.phone"/>
				</div>
				<div class="form-group">
					<form:label for="sponsor-email" path="">Sponsor Email</form:label>
					<form:input id="sponsor-email"
						cssClass="form-control" path="sponsor.email"/>
				</div>
			
				
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input id="funds" 
						class="form-control" path="authorizedFunds"/>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input id="hours" 
						class="form-control" path="authorizedHours"/>
				</div>
			
				<div class="form-group">
					<label for="date">Start Date(Jullian)</label>
					<form:input id="date" 
						class="form-control" path="date"/>
				</div>
			
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<form:textarea path="description" class="form-control" rows="3"></form:textarea>
					<form:errors path="description" />
				</div>
				
				<div class="form-group">
					<form:label for="poc" path="">POC</form:label>
					<form:input id="poc"
						cssClass="form-control" path="pointOfContact[0]"/>
				</div>
				
				<div class="form-group">
					<form:label for="poc2" path="">POC2</form:label>
					<form:input id="poc2"
						cssClass="form-control" path="pointOfContact[1]"/>
				</div>
				
				<div class="form-group">
					<form:label for="poc3" path="">POC3</form:label>
					<form:input id="poc3"
						cssClass="form-control" path="pointOfContact[2]"/>
				</div>
				
				
				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox id="special" path="special" />
				</div>
			
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form:form>
			
		</div>
	</div>
	


</body>
</html>