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
	<label for="doses">doses</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='doses' type='text' />
		<form:errors path='doses' />

	</div>
</div>
<div class="form-group">
	<label for="descricao">descricao</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='descricao' type='text' />
		<form:errors path='descricao' />

	</div>
</div>
<div class="form-group">
	<label for="observacoes">observacoes</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='observacoes' type='text' />
		<form:errors path='observacoes' />

	</div>
</div>
<div class="form-group">
	<label for="idEpoca">epoca</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
					
		<form:select path='idEpoca'>
			<form:option value="" label="Selecione" />
			<form:options items="${listaEpocas}" itemLabel="nome" itemValue="id" />
		</form:select>
		<form:errors path='idEpoca' />
		
	</div>
</div>
