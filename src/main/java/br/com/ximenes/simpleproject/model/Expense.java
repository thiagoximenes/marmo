package br.com.ximenes.simpleproject.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity(name = "EXPENSE")
public class Expense extends Action{

	private static final long serialVersionUID = 1L;
	
	public Expense() {}

	public Expense(Long id, String name, String createDate, BigDecimal value, Date createDateAutomatic, int month) {
		super(id, name, createDate, value, createDateAutomatic, month);
	}

}
