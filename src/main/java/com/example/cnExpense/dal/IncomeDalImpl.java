package com.example.cnExpense.dal;

import com.example.cnExpense.entity.Income;
import com.example.cnExpense.entity.User;
import com.example.cnExpense.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class IncomeDalImpl implements IncomeDal {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserService userService;

    @Override
    public Income getIncomeById(Long incomeId) {
    	Session session=entityManager.unwrap(Session.class);
    	
    	return session.get(Income.class, incomeId);

    }

    @Override
    public Income saveIncome(Long userId, Income newIncome) {
    	Session session=entityManager.unwrap(Session.class);
    	User user = userService.getUserById(userId);
    	newIncome.setUser(user);
    	session.save(newIncome);
    	return newIncome;

       
    }

    @Override
    public Income updateIncome(Long incomeId, Income income) {
    	Session session=entityManager.unwrap(Session.class);

    	Income newIncome = session.get(Income.class, incomeId);
    	newIncome.setAmount(income.getAmount());
    	newIncome.setDate(income.getDate());
    	newIncome.setDescription(income.getDescription());
    	newIncome.setIncomeType(income.getIncomeType());
    	session.update(newIncome);
    	  
    	return newIncome;
    }

}


