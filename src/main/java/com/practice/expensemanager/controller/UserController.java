package com.practice.expensemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    public PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> result = userService.getUsers();
        if(result.size() > 0){
            return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getOneUser(@PathVariable int id) throws Throwable {

        return userService.getOneUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@Valid @RequestBody User user) {
        //BCrypt password before saving to db
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        if (userService.postUser(user)) {
            return user;
        }
        return null;
    }
}
