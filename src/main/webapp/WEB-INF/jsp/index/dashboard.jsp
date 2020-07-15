<%@taglib tagdir="/WEB-INF/tags" prefix="ct"%>
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
								href="${linkTo[IndexController].index() }">Simple Project</a></li>
							<li class="breadcrumb-item active" aria-current="page">Dashboard</li>
						</ol>
					</nav>
				</h6>
				<h4>Welcome to dashboard!</h4>
				<p>This .JSP are visible only for <b>logged users</b>, like you.</p>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="content">
		<div class="row align-items-end">
			<div class="col-lg-4 col-md-6 col-sm-12" style="border-right: 1px solid #dcdcdc;">
				<div class="col-12 mb-3">
					<form class="form-style form-basic" action="/marmo/recipesonlist" method="post">
						<c:import url="../recipe/form.jsp"></c:import>
						<input type="submit" class="btn btn-primary" value="Registrar" />
					</form>
				</div>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Receitas <i class="fas fa-sort"></i></th>
								<th scope="col">Data <i class="fas fa-sort"></i></th>
								<th scope="col">Valor <i class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recipes}" var="recipe">
								<tr class="tr-item" role="row">
									<td id="name"> ${recipe.name}</td>
									<td id="createDate">${recipe.createDate}</td>
									<td id="value">${recipe.value}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12" style="border-right: 1px solid #dcdcdc;">
				<div class="col-12 mb-3">
					<form class="form-style form-basic" action="/marmo/expensesonlist" method="post">
						<c:import url="../expense/form.jsp"></c:import>
						<input type="submit" class="btn btn-primary" value="Registrar" />
					</form>
				</div>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Despesas <i class="fas fa-sort"></i></th>
								<th scope="col">Data <i class="fas fa-sort"></i></th>
								<th scope="col">Valor <i class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${expenses}" var="expense">
								<tr class="tr-item" role="row">
									<td id="name"> ${expense.name}</td>
									<td id="createDate">${expense.createDate}</td>
									<td id="value">${expense.value}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12">
			</div>
		</div>
	</div>
</div>

<ct:notificationAlert />

<%@ include file="../../footer.jsp"%>
