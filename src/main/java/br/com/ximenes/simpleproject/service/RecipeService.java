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
import br.com.ximenes.simpleproject.controller.RecipeController;
import br.com.ximenes.simpleproject.dao.RecipeDao;
import br.com.ximenes.simpleproject.model.Recipe;

@RequestScoped
public class RecipeService {
	
	@Inject private RecipeDao recipeDao;
	@Inject private Validator validator;
	@Inject private Result result;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void add(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).register();
		
		Recipe r;
		if(recipe.getCreateDate() == null) {
			Calendar cal = Calendar.getInstance();
			recipe.setCreateDate(sdf.format(cal.getTime()));
			r = new Recipe(recipe.getId(), recipe.getName(), recipe.getCreateDate() , recipe.getValue(), recipe.getCreateDateAutomatic(), catchMonth(recipe));
		}else {
			r = new Recipe(recipe.getId(), recipe.getName(), recipe.getCreateDate(), recipe.getValue(), recipe.getCreateDateAutomatic(), catchMonth(recipe));
		}
		recipeDao.add(r);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(RecipeController.class).list();
	}
	
	public void addOnList(Recipe recipe) {
		validator.onErrorRedirectTo(IndexController.class).dashboard();
		
		Recipe r;
		if(recipe.getCreateDate() == null) {
			Calendar cal = Calendar.getInstance();
			recipe.setCreateDate(sdf.format(cal.getTime()));
			r = new Recipe(recipe.getId(), recipe.getName(), recipe.getCreateDate() , recipe.getValue(), recipe.getCreateDateAutomatic(), catchMonth(recipe));
		}else {
			r = new Recipe(recipe.getId(), recipe.getName(), recipe.getCreateDate(), recipe.getValue(), recipe.getCreateDateAutomatic(), catchMonth(recipe));
		}
		recipeDao.add(r);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(IndexController.class).dashboard();
	}

	public int catchMonth(Recipe recipe) {
		Calendar cal = Calendar.getInstance();
		if (recipe.getCreateDate() != null) {
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(recipe.getCreateDate());
				cal.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return cal.get(Calendar.MONTH) + 1;
		} else {
			return cal.get(Calendar.MONTH) + 1;
		}
	}

	public void change(@Valid Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).register();
		
		if(recipe.getCreateDateAutomatic() == null) {
			Calendar cal = Calendar.getInstance();
			recipe.setCreateDateAutomatic(cal.getTime());
		}
		
		recipe = new Recipe(recipe.getId(), recipe.getName(), recipe.getCreateDate(), recipe.getValue(), recipe.getCreateDateAutomatic(), catchMonth(recipe));
		recipeDao.update(recipe);
		result.include("msg", "Receita atualizada.");
		result.redirectTo(RecipeController.class).list();
	}

	public void remove(Recipe recipe) {
		recipeDao.remove(recipe);
		result.include("msg", "Receita apagada.");
		result.redirectTo(RecipeController.class).list();
	}
	
}
