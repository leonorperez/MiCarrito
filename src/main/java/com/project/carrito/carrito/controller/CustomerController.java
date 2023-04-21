package com.project.carrito.carrito.controller;

import com.project.carrito.carrito.dto.CustomerDTO;
import com.project.carrito.carrito.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @PostMapping(value = "/customer/new")
    public ResponseEntity<?> save(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(iCustomerService.save(customerDTO), HttpStatus.OK);
    }

}
