package com.mvp.mvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvp.mvp.pojo.request.BudgetDetailsRequest;
import com.mvp.mvp.pojo.response.MVPResponse;
import com.mvp.mvp.service.BudgetService;

@RestController
@RequestMapping("budget/")
@CrossOrigin("*")
public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    private BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("save")
    public ResponseEntity<MVPResponse> budgetSaveHandler(@RequestBody BudgetDetailsRequest budgetDetailsRequest) {
        return ResponseEntity.ok(budgetService.saveBudgetDetails(budgetDetailsRequest));
    }

}
