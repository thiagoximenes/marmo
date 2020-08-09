<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input type="hidden" name="recipe.id" value="${recipe.id }" />

<input type="hidden" name="recipe.createDateAutomatic" value="${recipe.createDateAutomatic}" />

<div class="row">
	<div class="form-group col-sm">
		<label for="rcreateData">Data:</label>
		<input type="text" name="recipe.createDate" id="rcreateDate" class="form-control custom-date" value="${recipe.createDate}" />
	</div>
	<div class="form-group col-sm">
		<label for="rname">Nome:</label>
		<input type="text" name="recipe.name" id="rname" class="form-control" value="${recipe.name}" placeholder="Descrição breve" required />
	</div>
	<div class="form-group col-sm">
		<label for="rvalue">Valor:</label>
		<input type="text" name="recipe.value" id="rvalue" class="form-control" value="${recipe.value}" placeholder="Valor" required />
	</div>
</div>
	
