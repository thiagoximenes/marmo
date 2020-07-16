<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../../header.jsp"%>

<div class="container-fluid">
	<div class="header">
		<div class="row align-items-end mb-3">
			<div class="col">
				<h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${linkTo[IndexController].dashboard() }">Dashboard</a></li>
							<li class="breadcrumb-item" aria-current="page"><a href="${linkTo[ExpenseController].list() }">Receitas</a></li>
							<li class="breadcrumb-item active" aria-current="page">Register</li>
						</ol>
					</nav>
				</h6>
				<h4>Registrar despesa</h4>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="content">
		<div class="row align-items-end">
			<div class="col">
				<form class="form-style form-basic" action="/marmo/expenses" method="post">
					<c:import url="form.jsp"></c:import>
					<input type="submit" class="btn btn-primary" value="Registrar" />
					<a type="button" class="btn btn-dark" href="${linkTo[ExpenseController].list()}" data-toggle="tooltip" data-placement="bottom" title="Voltar">
						<i class="fa fa-arrow-left" aria-hidden="true"></i>
					</a>
				</form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../../footer.jsp"%>
