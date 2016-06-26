package org.tgo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tgo.domain.Expense;
import org.tgo.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public List<Expense> getAll() {
        return repository.getAll();
    }

    public void save(Expense expense) {
        repository.save(expense);
    }

}
