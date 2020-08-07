package br.com.ximenes.simpleproject.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ximenes.simpleproject.model.Expense;

@RequestScoped
public class ExpenseDao {

	@Inject private EntityManager manager;
	@Inject private Expense expense;
	
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
	
	public int catchMonth(Expense expense) {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}	
	
	public List<Expense> list() {
		TypedQuery<Expense> query = manager.createQuery("select u from EXPENSE u", Expense.class);
		return query.getResultList();
	}
	
	public List<Expense> listByMonth(){
		TypedQuery<Expense> query = manager.createQuery("SELECT e FROM EXPENSE e WHERE e.month =:eActualMonth", Expense.class);
		query.setParameter("rActualMonth", catchMonth(expense));
		return query.getResultList();
	}	
	
	public BigDecimal totalExpenseByMonth() {
		BigDecimal sum = new BigDecimal("0.000");
		
		TypedQuery<Expense> query = manager.createQuery("SELECT e FROM EXPENSE e WHERE e.month =:eActualMonth", Expense.class);
		query.setParameter("rActualMonth", catchMonth(expense));
		List<Expense> all = query.getResultList();
		
		for(Expense r : all) {
			sum = sum.add(r.getValue());
		}
		
		return sum;
	}
	
}
