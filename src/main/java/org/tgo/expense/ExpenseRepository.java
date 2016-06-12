package org.tgo.expense;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.tgo.expense.model.Expense;

public class ExpenseRepository {
    
    private EntityManager entityManager;
    
    private static ExpenseRepository instance;
    
    private ExpenseRepository() {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("costControl");
            entityManager = entityManagerFactory.createEntityManager();
    }
    
    public static ExpenseRepository getInstance(){
        
        if(instance == null){
            instance = new ExpenseRepository();
        }
        
        return instance;
        
    }
    
    public void save(Expense expense){
        entityManager.getTransaction().begin();
        entityManager.persist(expense);
        entityManager.getTransaction().commit();
    }
    

}
