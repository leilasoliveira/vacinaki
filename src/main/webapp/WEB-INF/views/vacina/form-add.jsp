<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
	<div>
		<div class="container min-container">
			<h2 class="basic-title">Add vacina</h2>
			<form:form role="form" cssClass="well" commandName="vacina"
				servletRelativeAction="/vacina" method="POST">
				<%@include file="form-inputs.jsp"%>
				<button type="submit" class="btn btn-primary" name="save">Submit</button>
				<button type="submit" class="btn btn-default" name="more">Save and add more</button>
			</form:form>
		</div>
	</div>
</template:admin>
