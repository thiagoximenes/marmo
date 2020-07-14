<%-- <%@ taglib tagdir="/WEB-INF/tags" prefix="ct"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input type="hidden" name="recipe.id" value="${recipe.id }" />

<div class="row">
	<div class="form-group col-sm">
		<label for="createData">Data:</label>
		<input type="date" name="recipe.createDate" id="createDate" class="form-control" value="${recipe.createDate}" required autofocus />
	</div>
	<div class="form-group col-sm">
		<label for="name">Nome:</label>
		<input type="text" name="recipe.name" id="name" class="form-control" value="${recipe.name}" placeholder="Descrição breve" required />
	</div>
	<div class="form-group col-sm">
		<label for="value">Valor:</label>
		<input type="text" name="recipe.value" id="value" class="form-control" value="${recipe.value}" placeholder="Valor" required />
	</div>
</div>
	
