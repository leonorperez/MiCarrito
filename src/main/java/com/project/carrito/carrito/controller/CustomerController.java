package com.project.carrito.carrito.controller;

import com.project.carrito.carrito.dto.CustomerDTO;
import com.project.carrito.carrito.dto.CustomerResponse;
import com.project.carrito.carrito.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @PostMapping(value = "/customer/new")
    public ResponseEntity<?> save(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(iCustomerService.save(customerDTO), HttpStatus.OK);
    }

    @GetMapping(value="/customer/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CustomerDTO customer = (iCustomerService.findById(id)).getCustomerDTO();

        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        CustomerResponse customerResponse = iCustomerService.delete(id);

     if (customerResponse.getMessage().equals("Ok")) {
           return new ResponseEntity<>("customer delete successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("customer could not be deleted", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="/customer/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CustomerDTO updatedCustomer) {
        CustomerDTO existingCustomer = iCustomerService.findById(id).getCustomerDTO();

        if (existingCustomer != null) {

            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setUser(updatedCustomer.getUser());
            existingCustomer.setPassword(updatedCustomer.getPassword());

            iCustomerService.update(existingCustomer);

            return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }







}
