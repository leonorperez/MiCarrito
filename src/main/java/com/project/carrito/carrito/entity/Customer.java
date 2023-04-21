package com.project.carrito.carrito.entity;

import com.project.carrito.carrito.dto.CustomerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name="name", nullable = false, length = 200)
        private String name;

        @Column(name="user", nullable = false, length = 50, unique = true)
        private String user;

        @Column(name="password", nullable = false, length = 50)
        private String password;
    public Customer(CustomerDTO customerDTO) {
        this.id = customerDTO.getId();
        this.name = customerDTO.getName();
        this.user = customerDTO.getUser();
        this.password = customerDTO.getPassword();
    }

    public Customer() {

    }
}
