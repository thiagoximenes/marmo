package br.com.ximenes.simpleproject.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.ximenes.simpleproject.model.Recipe;
import br.com.ximenes.simpleproject.service.RecipeService;

@Controller
public class RecipeController {
	
	@Inject private RecipeService recipeService;

	@Get("/recipes")
    public void index() {}

	@Get("/recipes/novo")
	public void novo() {}

	@Post("/recipes")
	public void criar(Recipe recipe) {
		recipeService.criar(recipe);
	}
	
	@Post("/recipes/editar")
	public void atualizar(Recipe recipe) {
		recipeService.atualizar(recipe);
    }

	@Get("/recipes/{recipe.id}/editar")
	public void editar(Recipe recipe) {}

	@Get("/recipes/{recipe.id}/apagar")
	public void apagar(Recipe recipe) {
		recipeService.apagar(recipe);
    }
	
}
