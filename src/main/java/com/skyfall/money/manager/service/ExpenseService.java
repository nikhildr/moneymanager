package com.skyfall.money.manager.service;

import com.skyfall.money.manager.model.Expense;

import java.util.List;

public interface ExpenseService {

    public Expense addExpense(Expense expense);

    public void deleteExpense(Integer id);

    public Expense updateExpense(Expense expense,Integer id);

    public List<Expense> getAllExpenses();

    public Expense findById(Integer id);
}
