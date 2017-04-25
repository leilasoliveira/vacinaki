<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<label for="valorInicial">valor inicial</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='valorInicial' type='text' />
		<form:errors path='valorInicial' />

	</div>
</div>
<div class="form-group">
	<label for="unidadeTempoInicial">unidade de tempo inicial</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:select path="unidadeTempoInicial">
			<form:option value="" label="Selecione" />
			<form:options items="${listaUnidadesTempo}" itemLabel="nome" />
		</form:select>
		<form:errors path='unidadeTempoInicial' />

	</div>
</div>
<div class="form-group">
	<label for="valorLimite">valor limite</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='valorLimite' type='text' />
		<form:errors path='valorLimite' />

	</div>
</div>
<div class="form-group">
	<label for="unidadeTempoLimite">unidade de tempo limite</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:select path="unidadeTempoLimite">
			<form:option value="" label="Selecione" />
			<form:options items="${listaUnidadesTempo}" itemLabel="nome" />
		</form:select>
		<form:errors path='unidadeTempoLimite' />

	</div>
</div>
