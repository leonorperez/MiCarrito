package com.project.carrito.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerDTO {
    private Long id;
    private String name;
    private String user;
    private String password;

}

