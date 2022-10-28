package com.practice.expensemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Expenditure> getExpenditures() {
        return expenditureService.getExpenditures();
    }

    @RequestMapping(value = "/exp/{id}", method = RequestMethod.GET)
    public Expenditure getOneExpenditure(@PathVariable int id) {
        return expenditureService.getOneExpenditure(id);
    }

    @RequestMapping(value = "/exp", method = RequestMethod.POST)
    public Expenditure postExpenditure(@Valid @RequestBody Expenditure exp) {
        if (expenditureService.postExpenditure(exp)) {
            return exp;
        }
        return null;
    }
}
