package br.com.ximenes.simpleproject.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.ximenes.simpleproject.dao.ExpenseDao;
import br.com.ximenes.simpleproject.dao.RecipeDao;
import br.com.ximenes.simpleproject.model.UserType;
import br.com.ximenes.simpleproject.model.Expense;
import br.com.ximenes.simpleproject.model.Recipe;
import br.com.ximenes.simpleproject.security.Protection;

@Controller
public class IndexController {

	@Inject private Result result;
	@Inject private RecipeDao recipeDao;
	@Inject private ExpenseDao expenseDao;
	
	@Path("/")
	public void index() {
	}

	@Protection(type = { UserType.ADMIN, UserType.NORMAL })
	@Get("/dashboard")
	public void dashboard() {
		List<Recipe> recipes = recipeDao.listByMonth();
		List<Expense> expenses = expenseDao.list();
		result.include("recipes", recipes);
		result.include("expenses", expenses);
		result.include("totalRecipeByMonth", recipeDao.totalRecipeByMonth());
	}
}