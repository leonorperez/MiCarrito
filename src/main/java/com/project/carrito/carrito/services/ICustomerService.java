package com.project.carrito.carrito.services;

import com.project.carrito.carrito.dto.CustomerDTO;
import com.project.carrito.carrito.dto.CustomerResponse;

public interface ICustomerService {
    public CustomerResponse save(CustomerDTO customerDTO);

}
