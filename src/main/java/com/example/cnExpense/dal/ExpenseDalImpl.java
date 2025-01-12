package com.example.cnExpense.dal;

import com.example.cnExpense.entity.Expense;
import com.example.cnExpense.entity.User;
import com.example.cnExpense.service.UserService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ExpenseDalImpl implements ExpenseDal {

    @Autowired
    EntityManager entityManager;
    
    @Autowired
    UserService userService;

    @Override
    public Expense saveExpense(Long userId, Expense expense) {
    	
    	Session session=entityManager.unwrap(Session.class);
    	User user = userService.getUserById(userId);
    	    expense.setUser(user);
    	    session.save(expense);
    	    
    	    
    	   return expense; 
    
    }

    @Override
    public Expense getExpenseById(Long expenseId) {
    	Session session=entityManager.unwrap(Session.class);
    	return session.get(Expense.class, expenseId);

    }
}


