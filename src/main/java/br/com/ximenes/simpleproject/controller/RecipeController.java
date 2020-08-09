package br.com.ximenes.simpleproject.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.ximenes.simpleproject.dao.RecipeDao;
import br.com.ximenes.simpleproject.model.Recipe;
import br.com.ximenes.simpleproject.service.RecipeService;

@Controller
public class RecipeController {
	
	@Inject private RecipeDao recipeDao;
	@Inject private Result result;
	@Inject private RecipeService recipeService;

	@Path("/recipes/register")
	public void register() {}

	@Post("/recipes")
	public void create(Recipe recipe) {
		recipeService.add(recipe);
	}

	@Post("/recipesonlist")
	public void createOnList(Recipe recipe) {
		recipeService.addOnList(recipe);
	}
	
	@Get("/recipes/{id}")
	public Recipe edit(Long id) {
		Recipe r = recipeDao.charge(id);
		r.getCreateDateAutomatic();
		return r;
	}
	
	@Put("/recipes/{id}/edit")
	public void update(Recipe recipe) {
		recipe.getCreateDateAutomatic();
		recipeService.change(recipe);
    }

	@Get("/recipes/{recipe.id}/remove")
	public void delete(Recipe recipe) {
		recipeService.remove(recipe);
    }
	
	@Path("/recipes/list")
	public void list() {
		List<Recipe> recipes = recipeDao.list();
		result.include("recipes", recipes);
	}
	
}
