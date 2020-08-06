<%@ taglib tagdir="/WEB-INF/tags" prefix="ct"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../../header.jsp"%>

<div class="container-fluid">
	<div class="header">
		<div class="row align-items-end mb-3">
			<div class="col">
				<h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="${linkTo[IndexController].dashboard() }">Dashboard</a></li>
<%-- 							<li class="breadcrumb-item" aria-current="page"><a href="${linkTo[RecipeController].list() }">Receitas</a></li> --%>
							<li class="breadcrumb-item active" aria-current="page">Register</li>
						</ol>
					</nav>
				</h6>
				<h4>Lista de receitas</h4>
			</div>
			
			<div class="col-auto">
				<a class="btn btn-light" href="${linkTo[RecipeController].register()}">
					<i class="fas fa-plus"></i> New recipe
				</a>
			</div>
		</div>
		<div class="row align-items-end">
			<div class="col buscar">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">
							<i class="fa fa-search" aria-hidden="true"></i>
						</span>
					</div>
					<input type="text" class="form-control filterable" aria-label="Default" aria-describedby="inputGroup-sizing-default">
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ID <i class="fas fa-sort"></i></th>
					<th scope="col">Nome <i class="fas fa-sort"></i></th>
					<th scope="col">Data <i class="fas fa-sort"></i></th>
					<th scope="col">Valor <i class="fas fa-sort"></i></th>
					<th scope="col">Ações <i class="fas fa-sort"></i></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${recipes}" var="recipe">
					<tr class="tr-item" role="row">
						<th> ${recipe.id}</th>
						<td id="name"> ${recipe.name}</td>
						<td id="createDate">${recipe.createDate} ${recipe.createDateAutomatic}</td>
						<td id="value">${recipe.value}</td>
						<td class="tdedita">
							<a href="<c:url value='/recipes/${recipe.id}'/>" data-toggle="tooltip" data-placement="bottom" title="Edit item"> <i class="far fa-edit"></i></a>
							<a class="deletarProduto" href="javascript:void(0);" data-href="<c:url value='/recipes/${recipe.id}/remove'/>"><i class="far fa-trash-alt"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<ct:notificationAlert />

<%@ include file="../../footer.jsp"%>

