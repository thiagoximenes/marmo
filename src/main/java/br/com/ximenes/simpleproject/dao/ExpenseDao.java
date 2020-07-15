package br.com.ximenes.simpleproject.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ximenes.simpleproject.model.Expense;

@RequestScoped
public class ExpenseDao {

	@Inject private EntityManager manager;
	
	public void add (Expense expense) {
		try {
			manager.getTransaction().begin();
			manager.persist(expense);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.close();
		}
	}

	public void remove (Expense expense) {
		try {
			manager.getTransaction().begin();
			expense = find(expense);
			manager.remove(expense);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.close();
		}
	}

	public void update (Expense expense) {
			try {
				manager.getTransaction().begin();
				manager.merge(expense);
				manager.getTransaction().commit();
			} catch (Exception e) {
				manager.close();
			}
	}
	
	public Expense find (Expense expense) {
		return manager.find(Expense.class, expense.getId());
	}
	
	public Expense charge (Long id) {
		return (Expense) this.manager.find(Expense.class, id);
	}
	
	public List<Expense> list() {
		TypedQuery<Expense> query = manager.createQuery("select u from EXPENSE u", Expense.class);
		return query.getResultList();
	}
	
}
