package com.skyfall.money.manager.serviceimpl;

import com.skyfall.money.manager.model.Expense;
import com.skyfall.money.manager.repository.ExpenseRepository;
import com.skyfall.money.manager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Override
    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public void deleteExpense(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Expense updateExpense(Expense expense,Integer id) {
        Expense dbExpense=repository.getById(id);
        dbExpense.setAmount(expense.getAmount());
        dbExpense.setDate(expense.getDate());
        dbExpense.setCategory(expense.getCategory());
        return repository.save(dbExpense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense findById(Integer id) {
        Expense dbExpense= repository.getById(id);
        return repository.getById(id);
    }
}
