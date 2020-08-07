package br.com.ximenes.simpleproject.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.ximenes.simpleproject.dao.ExpenseDao;
import br.com.ximenes.simpleproject.model.Expense;
import br.com.ximenes.simpleproject.service.ExpenseService;

@Controller
public class ExpenseController {
	
	@Inject private ExpenseDao expenseDao;
	@Inject private Result result;
	@Inject private ExpenseService expenseService;

	@Path("/expenses/register")
	public void register() {}

	@Post("/expenses")
	public void create(Expense expense) {
		expenseService.add(expense);
	}

	@Post("/expensesonlist")
	public void createOnList(Expense expense) {
		expenseService.addOnList(expense);
	}
	
	@Get("/expenses/{id}")
	public Expense edit(Long id) {
		Expense e = expenseDao.charge(id);
		e.getCreateDateAutomatic();
		return e;
	}
	
	@Put("/expenses/{id}/edit")
	public void update(Expense expense) {
		expense.getCreateDateAutomatic();
		expenseService.change(expense);
    }

	@Get("/expenses/{expense.id}/remove")
	public void delete(Expense expense) {
		expenseService.remove(expense);
    }
	
	@Path("/expenses/list")
	public void list() {
		List<Expense> expenses = expenseDao.list();
		result.include("expenses", expenses);
	}

	
}
