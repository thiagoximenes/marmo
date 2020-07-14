package br.com.ximenes.simpleproject.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ximenes.simpleproject.model.Recipe;

@RequestScoped
public class RecipeDao {

	@Inject private EntityManager manager;
	
	public void add (Recipe recipe) {
		try {
			manager.getTransaction().begin();
			manager.persist(recipe);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.close();
		}
	}

	public void remove (Recipe recipe) {
		try {
			manager.getTransaction().begin();
			recipe = find(recipe);
			manager.remove(recipe);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.close();
		}
	}

	public void update (Recipe recipe) {
			try {
				manager.getTransaction().begin();
				manager.merge(recipe);
				manager.getTransaction().commit();
			} catch (Exception e) {
				manager.close();
			}
	}
	
	public Recipe find (Recipe recipe) {
		return manager.find(Recipe.class, recipe.getId());
	}
	
	public Recipe charge (int id) {
		return (Recipe) this.manager.find(Recipe.class, id);
	}
	
	public List<Recipe> list() {
		try {
			TypedQuery<Recipe> query = manager.createQuery("select r from RECIPE r", Recipe.class);
			return query.getResultList();
		} finally {
			manager.close();
		}
	}

}
