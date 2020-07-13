package br.com.ximenes.simpleproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.ximenes.simpleproject.controller.RecipeController;
import br.com.ximenes.simpleproject.dao.RecipeDao;
import br.com.ximenes.simpleproject.model.Recipe;

@RequestScoped
public class RecipeService {
	
	@Inject private RecipeDao recipeDao;
	@Inject private Validator validator;
	
	@IncludeParameters
	public void criar(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).novo();
		recipeDao.add(recipe);
	}

	public void atualizar(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).novo();
		recipeDao.remove(recipe);
	}

	public void apagar(Recipe recipe) {
		validator.onErrorRedirectTo(RecipeController.class).novo();
		recipeDao.update(recipe);
	}
	
}
