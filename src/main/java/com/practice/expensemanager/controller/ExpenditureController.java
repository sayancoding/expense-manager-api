package com.practice.expensemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.expensemanager.entity.Expenditure;
import com.practice.expensemanager.service.ExpenditureService;

@RestController
public class ExpenditureController {
    
    @Autowired
    private ExpenditureService expenditureService;

    @RequestMapping(value = "/exp", method = RequestMethod.GET)
    public ResponseEntity<List<Expenditure>> getExpenditures() {
        List<Expenditure> expenditures = expenditureService.getExpenditures();
        if(expenditures.size() > 0){
            return new ResponseEntity<>(expenditures, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/exp/{id}", method = RequestMethod.GET)
    public Expenditure getOneExpenditure(@PathVariable long id) throws Throwable {
        return  (Expenditure)expenditureService.getOneExpenditure(id);
    }

    @RequestMapping(value = "/exp", method = RequestMethod.POST)
    public Expenditure postExpenditure(@Valid @RequestBody Expenditure exp) {
        if (expenditureService.postExpenditure(exp)) {
            return exp;
        }
        return null;
    }
}
