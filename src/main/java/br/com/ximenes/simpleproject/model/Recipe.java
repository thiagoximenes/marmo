package br.com.ximenes.simpleproject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity(name = "RECIPE")
public class Recipe extends Action implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Recipe() {}

	public Recipe(Long id, String name, String description, String createDate, BigDecimal value, Date createDateAutomatic, int month) {
		super(id, name, description, createDate, value, createDateAutomatic, month);
	}

}
