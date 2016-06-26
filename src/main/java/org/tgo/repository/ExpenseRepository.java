package org.tgo.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.tgo.domain.Expense;

@Repository
public class ExpenseRepository {
    
    private EntityManager entityManager;
    
    public ExpenseRepository() {
            
    }
    
    @PostConstruct
    public void init(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("costControl");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public void save(Expense expense){
        entityManager.getTransaction().begin();
        entityManager.persist(expense);
        entityManager.getTransaction().commit();
    }
    
    public List<Expense> getAll(){
        TypedQuery<Expense> query = entityManager.createNamedQuery("Expense.getAll", Expense.class);
        return query.getResultList();
    }
    
}
