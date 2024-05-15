package com.mvp.mvp.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvp.mvp.pojo.response.MVPResponse;
import com.mvp.mvp.service.UtilService;

@RestController
@RequestMapping("/util/")
@CrossOrigin("*")
public class UtilController {
    private final UtilService utilService;

    @Autowired
    private UtilController(UtilService utilService) {
        this.utilService = utilService;
    }

    @GetMapping("fetchcountries")
    public ResponseEntity<MVPResponse> fetchAllCountries() {
        return ResponseEntity.ok(utilService.fetchAllCountries());
    }

    @GetMapping("fetchcity")
    public ResponseEntity<MVPResponse> fetchAllCities() {
        return ResponseEntity.ok(utilService.fetchAllCities());
    }

    @GetMapping("fetchrole")
    public ResponseEntity<MVPResponse> fetchAllRoles() {
        return ResponseEntity.ok(utilService.fetchAllRoles());
    }

    @GetMapping("fetchroletype")
    public ResponseEntity<MVPResponse> fetchAllRoleTypes() {
        return ResponseEntity.ok(utilService.fetchAllRoleTypes());
    }

    @GetMapping("fetchroletier")
    public ResponseEntity<MVPResponse> fetchAllRoleTiers() {
        return ResponseEntity.ok(utilService.fetchAllRoleTiers());
    }

    @GetMapping("getbillinghours")
    public ResponseEntity<MVPResponse> getBillingHours(@RequestParam("lookupname") String lookUpName) throws UnsupportedEncodingException {

        return ResponseEntity.ok(utilService.getBillingHours(URLDecoder.decode(lookUpName, "UTF-8")));
    }
}
