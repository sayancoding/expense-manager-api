package com.practice.expensemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.expensemanager.dao.UserDAO;
import com.practice.expensemanager.entity.User;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserDAO userDAO;

    public List<User> getUsers() {
        return (List<User>) userDAO.findAll();
    }

    public User getOneUser(int id) {
        return (User) userDAO.findById(id);
    }

    public Boolean postUser(User user) {
        if (userDAO.save(user) != null) {
            return true;
        }
        return false;
    }
}
