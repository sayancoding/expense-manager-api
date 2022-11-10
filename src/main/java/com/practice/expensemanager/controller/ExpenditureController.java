package com.practice.expensemanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.practice.expensemanager.payload.CommonUtil;
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
        expenditures = expenditures.stream().filter((exp) -> exp.getUser().getId() == CommonUtil._uid).collect(Collectors.toList());
        if(expenditures.size() > 0){
            return new ResponseEntity<>(expenditures, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/exp/{id}", method = RequestMethod.GET)
    public Expenditure getOneExpenditure(@PathVariable long id) throws Throwable {
        Expenditure exp = (Expenditure)expenditureService.getOneExpenditure(id);
        if(exp.getId() == CommonUtil._uid){
            return exp;
        }
        return null ;
    }

    @RequestMapping(value = "/exp", method = RequestMethod.POST)
    public Expenditure postExpenditure(@Valid @RequestBody Expenditure exp) {
        if (expenditureService.postExpenditure(exp)) {
            return exp;
        }
        return null;
    }
}
