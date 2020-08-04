package br.com.ximenes.simpleproject.service;

import java.util.Calendar;

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
	
//	@IncludeParameters
	public void add(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).register();
		Recipe r = new Recipe(recipe.getId(), recipe.getName(), recipe.getCreateDate(), recipe.getValue(), recipe.getCreateDateAutomatic(), catchMonth());
		recipeDao.add(r);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(RecipeController.class).list();
	}
	
	public void addOnList(Recipe recipe) {
		validator.onErrorRedirectTo(IndexController.class).dashboard();
		Recipe r = new Recipe(recipe.getId(), recipe.getName(), recipe.getCreateDate(), recipe.getValue(), recipe.getCreateDateAutomatic(), catchMonth());
		recipeDao.add(r);
		result.include("msg", "Receita cadastrada.");
		result.redirectTo(IndexController.class).dashboard();
	}

	public int catchMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}

	public void change(@Valid Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).register();
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
