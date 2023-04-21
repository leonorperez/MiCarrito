package com.project.carrito.carrito.repository;

import com.project.carrito.carrito.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
