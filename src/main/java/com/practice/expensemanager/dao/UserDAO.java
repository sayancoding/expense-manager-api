package com.practice.expensemanager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.expensemanager.entity.User;

import java.util.Optional;

@Repository
public interface UserDAO extends CrudRepository<User,Integer> {
    public Optional<?> findById(int id);
    public Optional<?> findByUsername(String username);
}
