package com.practice.expensemanager.service;

import com.practice.expensemanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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

    public User getOneUser(int id) throws Throwable {
        return (User) userDAO.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found at ID:"+id));
    }

    public Boolean postUser(User user) {
        if (userDAO.save(user) != null) {
            return true;
        }
        return false;
    }
}
