package com.practice.expensemanager.security;

import com.practice.expensemanager.dao.UserDAO;
import com.practice.expensemanager.entity.User;
import com.practice.expensemanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userDAO.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username + " : user not found"));
        return user;
    }
}
