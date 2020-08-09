package br.com.ximenes.simpleproject.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.ximenes.simpleproject.dao.ExpenseDao;
import br.com.ximenes.simpleproject.dao.RecipeDao;
import br.com.ximenes.simpleproject.model.Expense;
import br.com.ximenes.simpleproject.model.Recipe;
import br.com.ximenes.simpleproject.model.UserType;
import br.com.ximenes.simpleproject.security.Protection;
import br.com.ximenes.simpleproject.service.IndexService;

@Controller
public class IndexController {

	@Inject private Result result;
	@Inject private RecipeDao recipeDao;
	@Inject private ExpenseDao expenseDao;
	@Inject private IndexService indexService;
	
	@Path("/")
	public void index() {
	}

	@Protection(type = { UserType.ADMIN, UserType.NORMAL })
	@Get("/dashboard")
	public void dashboard() {
		List<Recipe> recipes = recipeDao.listByMonth();
		List<Expense> expenses = expenseDao.listByMonth();
		result.include("recipes", recipes);
		result.include("expenses", expenses);
//		if(recipes.get(1).getMonth() != 0) {
//		}
		
//		System.out.println("IUH" + recipes.get(1).getMonth());
		
//		System.out.println("jhgf" + recipes.get(0));
		
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int i = cal.get(Calendar.MONTH) + 1;
		
		result.include("actualMonth", indexService.getMonth(i));
		
		if(!recipes.isEmpty())
			result.include("actualMonth", indexService.getMonth(i));
		else
			result.include("noRecipeRegisters", "Nenhum registro foi encontrado.");

		if(!expenses.isEmpty())
			result.include("actualMonth", indexService.getMonth(expenses.get(0).getMonth()));
		else
			result.include("noExpenseRegisters", "Nenhum registro foi encontrado.");

		result.include("totalRecipeByMonth", recipeDao.totalRecipeByMonth());
		result.include("totalExpenseByMonth", expenseDao.totalExpenseByMonth());
	}
}