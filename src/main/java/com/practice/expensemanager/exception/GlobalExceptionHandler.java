package com.practice.expensemanager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgNotValidException(MethodArgumentNotValidException excep){
        Map<String,String> map = new HashMap<>();
        excep.getBindingResult().getAllErrors().forEach(er->{
            String errField = ((FieldError)er).getField();
            String errMsg = er.getDefaultMessage();
            map.put(errField, errMsg);
        });
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
    
}
