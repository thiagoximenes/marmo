<%-- <%@ taglib tagdir="/WEB-INF/tags" prefix="ct"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<input type="hidden" name="recipe.id" value="${recipe.id }" />
<input type="text" name="recipe.createDate" id="createDate" class="form-control" value='<fmt:formatDate value="${recipe.createDate}" pattern="dd/MM/yyyy"/>' required autofocus/>
<input type="text" name="recipe.name" id="name" class="form-control" value="${recipe.name}" placeholder="Descrição breve" required />
<input type="text" name="recipe.value" id="value" class="form-control" value="${recipe.value}" placeholder="Valor" required />
