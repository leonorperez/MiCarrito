package com.project.carrito.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private CustomerDTO customerDTO;
    private String message;

    public CustomerResponse(String message) {
        this.message = message;
    }

}
