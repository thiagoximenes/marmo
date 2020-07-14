package br.com.ximenes.simpleproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.ximenes.simpleproject.controller.RecipeController;
import br.com.ximenes.simpleproject.dao.RecipeDao;
import br.com.ximenes.simpleproject.model.Recipe;

@RequestScoped
public class RecipeService {
	
	@Inject private RecipeDao recipeDao;
	@Inject private Validator validator;
	@Inject private Result result;
	
	@IncludeParameters
	public void add(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).register();
		recipeDao.add(recipe);
		result.redirectTo(RecipeController.class).register();
	}

	public void change(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).register();
		recipeDao.remove(recipe);
		result.redirectTo(RecipeController.class).register();
	}

	public void remove(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).register();
		recipeDao.update(recipe);
		result.redirectTo(RecipeController.class).register();
	}
	
}
