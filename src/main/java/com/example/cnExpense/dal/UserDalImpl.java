package com.example.cnExpense.dal;

import com.example.cnExpense.entity.Expense;
import com.example.cnExpense.entity.Income;
import com.example.cnExpense.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDalImpl implements UserDal {

    @Autowired
    EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
      Session session = entityManager.unwrap(Session.class);
      return session.get(User.class, id);
    }

    @Override
    public User saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
        return user;

    }

    @Override
    public User updateUser(Long userId, User user) {
        Session session = entityManager.unwrap(Session.class);
        User currUser = getUserById(userId);
        currUser.setAddress(user.getAddress());
        currUser.setBudget(user.getBudget());
        currUser.setEmail(user.getEmail());
        currUser.setNickname(user.getNickname());
        currUser.setUsername(user.getUsername());
        currUser.setIsbudgetSet(user.isIsbudgetSet());
        return currUser;

    
    }

    @Override
    public User setBudget(Long userId, double budget) {
    	 Session session = entityManager.unwrap(Session.class);
         User currUser = getUserById(userId);
         currUser.setBudget(budget);
         session.update(currUser);
         return currUser;
    }

    @Override
    public double getTotalExpense(Long userId) {
    	Session session = entityManager.unwrap(Session.class);
        User currUser = getUserById(userId);
      List<Expense> listOfExpenses =  currUser.getExpenses();
      double expenceAmount = 0;
      for(Expense expense : listOfExpenses) {
  	    
    	  expenceAmount =  expenceAmount + expense.getAmount();
      }
      return expenceAmount;

    }

    @Override
    public double getQuotation(Long userId) {
    	Session session = entityManager.unwrap(Session.class);
        User currUser = getUserById(userId);
      List<Expense> listOfExpenses =  currUser.getExpenses();
      List<Income> listOfIncome = currUser.getIncomes();
      
      double expenceAmount = 0;
      double incomeAmount = 0;

      
      
      for(Expense expense : listOfExpenses) {
    	    
    	  expenceAmount =  expenceAmount + expense.getAmount();
      }
      
      for(Income income : listOfIncome) {
  	    
    	  incomeAmount =  incomeAmount + income.getAmount();
      }
      double result = incomeAmount -expenceAmount;
      return result;
      
    }

    @Override
    public double getAvgExpenseData(Long userId) {
    	 User currUser = getUserById(userId);
         List<Expense> listOfExpenses =  currUser.getExpenses();
         
         double expenceAmount = getTotalExpense(userId);
         double result = expenceAmount/listOfExpenses.size();
         
         return result;
         

    }
}


