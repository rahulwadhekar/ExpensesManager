package com.example.cnExpense.service;

import com.example.cnExpense.dal.IncomeDal;
import com.example.cnExpense.entity.Income;
import com.example.cnExpense.entity.User;
import com.example.cnExpense.exception.InvalidInputException;
import com.example.cnExpense.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncomeService {
   
    @Autowired
    private IncomeDal incomeDal;

    @Transactional
    public Income getIncomeById(Long incomeId) {
    	Income income = incomeDal.getIncomeById(incomeId);
    	
    	if(income == null) {
    		 throw new NotFoundException(" Income Not Found with id "+ incomeId);

    	}
    	
        return income;
    }

    @Transactional
    public Income saveIncome(Long userId,Income income) {
    	
    	Income currIncome =incomeDal.saveIncome(userId, income);
    	if(currIncome == null) {
    		throw new InvalidInputException("Invalid Income");

    	}
        return currIncome;
    }

    @Transactional
    public Income editIncome(Long incomeId, Income income) {
    	Income currIncome = incomeDal.updateIncome(incomeId, income);
    	if(currIncome == null) {
   		 throw new NotFoundException(" Income Not Found with id "+ incomeId);

    	}
       return currIncome;
    }
}