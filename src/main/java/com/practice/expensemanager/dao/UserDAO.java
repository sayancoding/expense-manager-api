package com.practice.expensemanager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.expensemanager.entity.User;

@Repository
public interface UserDAO extends CrudRepository<User,Integer> {
    public User findById(int id);
}
