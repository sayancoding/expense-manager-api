package com.practice.expensemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.expensemanager.entity.User;
import com.practice.expensemanager.service.UserService;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getOneUser(@PathVariable int id) {
        return userService.getOneUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        if (userService.postUser(user)) {
            return user;
        }
        return user;
    }
}
