package com.practice.expensemanager.controller;

import com.practice.expensemanager.entity.User;
import com.practice.expensemanager.payload.CommonUtil;
import com.practice.expensemanager.payload.JwtAuthRequest;
import com.practice.expensemanager.payload.JwtAuthResponse;
import com.practice.expensemanager.payload.ResponseMessage;
import com.practice.expensemanager.security.JwtTokenHelper;
import com.practice.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Throwable {
        this.authenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

        String token = this.jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        User user = userService.getByUsername(userDetails.getUsername());
        response.setToken(token);
        response.setUid(user.getId());
        response.setUsername(user.getUsername());
        response.setName(user.getName());
        response.setLoginAt(new Date());

        CommonUtil.set(response.getUid(), response.getUsername(), response.getName(), true);
        System.out.println(CommonUtil._uid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/logout")
    public ResponseEntity<ResponseMessage> clearAuth(){
        CommonUtil.reset();
        return new ResponseEntity<>(new ResponseMessage("User logged out and isLogged status : "+CommonUtil._isLogged),HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        this.authenticationManager.authenticate(authenticationToken);
    }
}
