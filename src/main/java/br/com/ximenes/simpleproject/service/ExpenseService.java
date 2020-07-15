package br.com.ximenes.simpleproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.ximenes.simpleproject.controller.IndexController;
import br.com.ximenes.simpleproject.controller.ExpenseController;
import br.com.ximenes.simpleproject.dao.ExpenseDao;
import br.com.ximenes.simpleproject.model.Expense;

@RequestScoped
public class ExpenseService {
	
	@Inject private ExpenseDao expenseDao;
	@Inject private Validator validator;
	@Inject private Result result;
	
//	@IncludeParameters
	public void add(Expense expense) {
		validator.onErrorRedirectTo(ExpenseController.class).register();
		expenseDao.add(expense);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(ExpenseController.class).list();
	}
	
	public void addOnList(Expense expense) {
		validator.onErrorRedirectTo(IndexController.class).dashboard();
		expenseDao.add(expense);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(IndexController.class).dashboard();
	}

	public void change(@Valid Expense expense) {
		validator.onErrorRedirectTo(ExpenseController.class).register();
		expenseDao.update(expense);
		result.include("msg", "Receita atualizada.");
		result.redirectTo(ExpenseController.class).list();
	}

	public void remove(Expense expense) {
		expenseDao.remove(expense);
		result.include("msg", "Receita apagada.");
		result.redirectTo(ExpenseController.class).list();
	}
	
}
