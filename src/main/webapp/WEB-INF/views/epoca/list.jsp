<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
	<jsp:attribute name="extraStyles">
<link rel="stylesheet"
			href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
	<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
	<jsp:body>
  <div>
    <div class="container min-container">
      <h2 class="basic-title">List epoca</h2>
        <div class="well">
          <table
						class="table table-condensed table-bordered table-striped table-hover">
          		  <thead>
	                  <tr>
	                  	<td>id</td>
		                <td>nome</td>
		                <td>idade inicial</td>
						<td>idade limite</td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}'
								var='object'>         		
	                  <tr>
						<td><a href="<c:url value='/epoca'/>/${object.id}">${object.id}</a></td>
		                  	<td>${object.nome}</td>
		                  	<td>
		                  		<c:if test="${not empty object.valorInicial}">
		                  			${object.valorInicial} ${object.unidadeTempoInicial.nome}(s)
		                  		</c:if>
		                  	</td>
		                  	<td>
		                  		<c:if test="${not empty object.valorLimite}">
		                  			${object.valorLimite} ${object.unidadeTempoLimite.nome}(s)
		                  		</c:if>
		                  	</td>
	                    <td><a
										href="<c:url value='/epoca/remove'/>/${object.id}">Remove</a></td>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}"
						page="${param.page}" action="/epoca" />
          <a href="<c:url value='/epoca/form'/>" class="btn btn-success"><span
						class="glyphicon glyphicon-plus-sign"></span> Add New</a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
