package com.atilio.pruebalinktic.controller;

import com.atilio.pruebalinktic.entity.*;
import com.atilio.pruebalinktic.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SettlementController {
    @Autowired
    SettlementService service;

    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<List<Customer>> searchUser(@RequestBody List<CustomerInputData> inputDataList) {
        List<Customer> auxCus = new ArrayList<>();
        for (CustomerInputData inputData : inputDataList ) {
            Customer result = service.findCustomer(inputData);
            if (result != null) {
                auxCus.add(result);
            }
        }
        return new ResponseEntity<>(auxCus, HttpStatus.OK);

    }
    @PostMapping("/calculate")
    @ResponseBody
    public ResponseEntity<List<CustomerTotal>> calculateSettlement(@RequestBody List<CustomerInputData> inputDataList) {
        List<CustomerTotal> customerTotalList = new ArrayList<>();
        for (CustomerInputData inputData : inputDataList ) {
            if (inputData.valorAsegurado() <= 0) {
                continue;
            }
            CustomerTotal customerTotal = service.calculateTotalSettlement(inputData);
            if (customerTotal != null) {
                customerTotalList.add(customerTotal);
            }
        }
        return new ResponseEntity<>(customerTotalList, HttpStatus.OK);

    }
}