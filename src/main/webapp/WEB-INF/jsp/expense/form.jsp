<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input type="hidden" name="expense.id" value="${expense.id }" />

<input type="hidden" name="expense.createDateAutomatic" value="${expense.createDateAutomatic}" />

<div class="row">
	<div class="form-group col-sm">
		<label for="ecreateData">Data:</label>
		<input type="date" name="expense.createDate" id="ecreateDate" class="form-control custom-date" value="${expense.createDate}" />
	</div>
	<div class="form-group col-sm">
		<label for="ename">Nome:</label>
		<input type="text" name="expense.name" id="ename" class="form-control" value="${expense.name}" placeholder="Descrição breve" required />
	</div>
	<div class="form-group col-sm">
		<label for="evalue">Valor:</label>
		<input type="text" name="expense.value" id="evalue" class="form-control" value="${expense.value}" placeholder="Valor" required />
	</div>
</div>
<div class="row">
	<div class="form-group col-sm">
		<label for="edescription">Descrição (opcional):</label>
		<textarea type="text" name="expense.description" id="edescription" class="form-control" value="${expense.description}" placeholder="Descreva essa movimentação"></textarea>
	</div>
</div>
	
