<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project manager</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
<script src="<spring:url value="/resources/js/resource.js"/>"></script>
</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">
	
		<div class="row">
			<h1>Resource</h1>
		</div>
		
		<spring:url value="/resource/review" var="formUrl"/>
		<form:form action="${formUrl}" method="post" modelAttribute="resource">
			<div class="row">
				
				<div class="form-group">
					<form:label path="" for="resource-name">Name</form:label>
					<form:input path="name" cssClass="form-control" id="resource-name"/>
				</div>
				<div class="form-group">
					<form:label path="" for="resource-type">Type</form:label> 
					<form:select path="type" items="${typeOptions}" cssClass="selectpicker" id="resource-type"/>
				</div>

				<div class="form-group">
					<form:label path="" for="cost">Cost</form:label> 
					<form:input path="cost" id="cost" cssClass="form-control"/>
				</div>

				<div class="form-group">
					<label for="unit">Unit of Measure</label> 
					<span><form:radiobuttons  path="unitOfMesure" items="${radioOptions}"/></span>
				</div>

				<div class="form-group">
					<label for="indicators">Indicators</label> 
					<span><form:checkboxes id="indicators" path="indicators" items="${checkOptions}"/></span>
					<a id="request-link" href="<spring:url value="/resource/request" />">Send Request</a>
				</div>
				
				

				<div class="form-group">
					<label for="notes">Notes</label> 
					<form:textarea id="notes" path="notes" cssClass="form-control" rows="3"/>
				</div>
				
				<button type="submit"  class="btn btn-default">Submit</button> <br>
			</div>
		</form:form>
		
		<spring:url value="/resource/upload" var="upload"/>
		
		<form:form action="${upload}" method="POST" enctype="multipart/form-data">
			File To Upload: <input type="file" name="file"> <br>
			<input type="submit" value="Upload"> Press here to upload the file!
		</form:form>
		
		
	</div>

</body>
</html>