package com.practice.expensemanager.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.expensemanager.entity.Expenditure;

import java.util.Optional;

@Repository
public interface ExpenditureDAO extends CrudRepository<Expenditure,Long>{
    public Optional findById(long id);
}
