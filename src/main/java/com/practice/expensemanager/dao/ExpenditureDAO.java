package com.practice.expensemanager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.expensemanager.entity.Expenditure;

@Repository
public interface ExpenditureDAO extends CrudRepository<Expenditure,Long>{
    public Expenditure findById(int id);
}
