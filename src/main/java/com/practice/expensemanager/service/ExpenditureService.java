package com.practice.expensemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.expensemanager.dao.ExpenditureDAO;
import com.practice.expensemanager.entity.Expenditure;

@Service
public class ExpenditureService {
    
    @Autowired
    private ExpenditureDAO expenditureDAO;

    public List<Expenditure> getExpenditures(){
        return (List<Expenditure>) expenditureDAO.findAll();
    }

    public Expenditure getOneExpenditure(int id){
        return (Expenditure) expenditureDAO.findById(id);
    }

    public Boolean postExpenditure(Expenditure exp){
        if(expenditureDAO.save(exp) != null){
            return true;
        }
        return false;
    }
}
