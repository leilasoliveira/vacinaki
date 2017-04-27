<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="form-group">
	<label for="nome">nome</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='nome' type='text' />
		<form:errors path='nome' />
	</div>
</div>
<div class="form-group">
	<label for="email">email</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='email' type='text' />
		<form:errors path='email' />
	</div>
</div>
<div class="form-group">
	<label for="senha">senha</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:password path='senha' />
		<form:errors path='senha' />
	</div>
</div>
<div class="form-group">
	<label for="dataNasc">data de nascimento</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<fmt:formatDate value="${dataNasc}" pattern="dd/MM/yyyy" var="dataNasc"/>
		<form:input path='dataNasc' type='date' value="${dataNasc}" />
		<form:errors path='dataNasc' />
	</div>
</div>