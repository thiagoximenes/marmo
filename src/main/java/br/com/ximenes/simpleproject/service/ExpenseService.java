package br.com.ximenes.simpleproject.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void add(Expense expense) {
		validator.onErrorRedirectTo(ExpenseController.class).register();
		
		Expense e;
		if(expense.getCreateDate() == null) {
			Calendar cal = Calendar.getInstance();
			expense.setCreateDate(sdf.format(cal.getTime()));
			e = new Expense(expense.getId(), expense.getName(), expense.getCreateDate() , expense.getValue(), expense.getCreateDateAutomatic(), catchMonth(expense));
		}else {
			e = new Expense(expense.getId(), expense.getName(), expense.getCreateDate(), expense.getValue(), expense.getCreateDateAutomatic(), catchMonth(expense));
		}
		expenseDao.add(e);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(ExpenseController.class).list();
	}
	
	public void addOnList(Expense expense) {
		validator.onErrorRedirectTo(IndexController.class).dashboard();
		
		Expense e;
		if(expense.getCreateDate() == null) {
			Calendar cal = Calendar.getInstance();
			expense.setCreateDate(sdf.format(cal.getTime()));
			e = new Expense(expense.getId(), expense.getName(), expense.getCreateDate() , expense.getValue(), expense.getCreateDateAutomatic(), catchMonth(expense));
		}else {
			e = new Expense(expense.getId(), expense.getName(), expense.getCreateDate(), expense.getValue(), expense.getCreateDateAutomatic(), catchMonth(expense));
		}
		expenseDao.add(e);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(IndexController.class).dashboard();
	}

	public int catchMonth(Expense expense) {
		Calendar cal = Calendar.getInstance();
		if (expense.getCreateDate() != null) {
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(expense.getCreateDate());
				cal.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return cal.get(Calendar.MONTH) + 1;
		} else {
			return cal.get(Calendar.MONTH) + 1;
		}
	}

	public void change(@Valid Expense expense) {
		validator.onErrorRedirectTo(ExpenseController.class).register();
		
		if(expense.getCreateDateAutomatic() == null) {
			Calendar cal = Calendar.getInstance();
			expense.setCreateDateAutomatic(cal.getTime());
		}
		
		expense = new Expense(expense.getId(), expense.getName(), expense.getCreateDate(), expense.getValue(), expense.getCreateDateAutomatic(), catchMonth(expense));
		expenseDao.update(expense);
		result.include("msg", "Receita atualizada.");
		result.redirectTo(ExpenseController.class).list();
	}

	public void remove(Expense expense) {
		expenseDao.remove(expense);
		result.include("msg", "Receita apagada.");
		result.redirectTo(ExpenseController.class).list();
	}
	
	public String monthToString(int month) {
		String str = "";
		
		switch (month) {
		case 1:
			str = "Janeiro";
			break;
		case 2:
			str = "Fevereiro";
			break;
		case 3:
			str = "Março";
			break;
		case 4:
			str = "Abril";
			break;
		case 5:
			str = "Maio";
			break;
		case 6:
			str = "Junho";
			break;
		case 7:
			str = "Julho";
			break;
		case 8:
			str = "Agosto";
			break;
		case 9:
			str = "Setembro";
			break;
		case 10:
			str = "Outubro";
			break;
		case 11:
			str = "Novembro";
			break;
		case 12:
			str = "Dezembro";
			break;

		default:
			str = "Mês não encontrado.";
			break;
		}
		
		return str;
	}
	
}
