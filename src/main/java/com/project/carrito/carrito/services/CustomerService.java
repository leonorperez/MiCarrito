package com.project.carrito.carrito.services;

import com.project.carrito.carrito.dto.CustomerDTO;
import com.project.carrito.carrito.dto.CustomerResponse;
import com.project.carrito.carrito.entity.Customer;
import com.project.carrito.carrito.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository icustomerRepository;

    public CustomerResponse save(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        try {
            icustomerRepository.save(customer);
            String message = "El objeto CustomerDTO se guardó correctamente";
            return new CustomerResponse(customerDTO, message);
        }catch (Exception e) {
            String message = "No se pudo guardar el objeto CustomerDTO";
            return new CustomerResponse(customerDTO, message);
        }
    }
}
