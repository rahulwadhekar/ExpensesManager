package com.example.cnExpense.service;

import com.example.cnExpense.dal.ExpenseDal;
import com.example.cnExpense.entity.Expense;
import com.example.cnExpense.exception.InvalidInputException;
import com.example.cnExpense.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseDal expenseDal;

    @Transactional
    public Expense saveExpense(Long userId, Expense expense) {
    	Expense cuurExpense = expenseDal.saveExpense(userId, expense);
    	
    	if(cuurExpense == null) {
    		throw new InvalidInputException("Invalid Expense");
    	}
    	return cuurExpense;
      
    }

    @Transactional
    public Expense getExpenseById(Long expenseId) {
    	Expense expense = expenseDal.getExpenseById(expenseId);
    	
    	if(expense == null) {
   		 throw new NotFoundException(" Expense Not Found with id "+ expenseId);
    	}
    	return expense;
    	
         
    }
}