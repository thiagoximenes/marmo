<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input type="hidden" name="expense.id" value="${expense.id }" />

<div class="row">
	<div class="form-group col-sm">
		<label for="createData">Data:</label>
		<input type="date" name="expense.createDate" id="createDate" class="form-control custom-date" value="${expense.createDate}" />
	</div>
	<div class="form-group col-sm">
		<label for="name">Nome:</label>
		<input type="text" name="expense.name" id="name" class="form-control" value="${expense.name}" placeholder="Descrição breve" required />
	</div>
	<div class="form-group col-sm">
		<label for="value">Valor:</label>
		<input type="text" name="expense.value" id="value" class="form-control" value="${expense.value}" placeholder="Valor" required />
	</div>
</div>
	
