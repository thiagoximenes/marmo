package br.com.ximenes.simpleproject.dao;

import java.util.Calendar;
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
	
	public Recipe charge (Long id) {
		return (Recipe) this.manager.find(Recipe.class, id);
	}
	
	public int catchMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}	
	
	public List<Recipe> list() {
		TypedQuery<Recipe> query = manager.createQuery("SELECT r FROM RECIPE r", Recipe.class);
		return query.getResultList();
	}	

	public List<Recipe> listByMonth() {
		TypedQuery<Recipe> query = manager.createQuery("SELECT r FROM RECIPE r WHERE r.month =:rActualMonth", Recipe.class);
		query.setParameter("rActualMonth", catchMonth());
		return query.getResultList();
	}	
	
}
