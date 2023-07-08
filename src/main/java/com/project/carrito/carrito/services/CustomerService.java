package com.project.carrito.carrito.services;

import com.project.carrito.carrito.dto.CustomerDTO;
import com.project.carrito.carrito.dto.CustomerResponse;
import com.project.carrito.carrito.entity.Customer;
import com.project.carrito.carrito.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository icustomerRepository;

    public CustomerResponse save(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        try {
            icustomerRepository.save(customer);
            String message = "El objeto CustomerDTO se guardó correctamente";
            return new CustomerResponse(customerDTO, message);
        } catch (Exception e) {
            String message = "No se pudo guardar el objeto CustomerDTO";
            return new CustomerResponse(customerDTO, message);
        }
    }

    public CustomerResponse findById(Long id) {
        Optional<Customer> optionalCustomer = icustomerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            CustomerDTO customerDTO = mapToCustomerDTO(optionalCustomer.get());
            String message = "El objeto Customer con ID " + id + " se encontró correctamente.";
            return new CustomerResponse(customerDTO, message);
        } else {
            String message = "No se pudo encontrar un objeto Customer con ID " + id + ".";
            return new CustomerResponse(message);
        }
    }

    public CustomerResponse delete(Long id) {
        String message = "";
        if(icustomerRepository.existsById(id)){
            try {
                icustomerRepository.deleteById(id);
                message = "Ok";

            } catch (EmptyResultDataAccessException e) {
                message = e.getMessage();
            }
        }else{
            message = "Customer with ID " + id + " not found.";
        }

        return new CustomerResponse(message);
    }


        public void update(CustomerDTO customer) {

            Customer entity = new Customer();
            entity.setId(customer.getId());
            entity.setName(customer.getName());
            entity.setUser(customer.getUser());
            entity.setPassword(customer.getPassword());


            icustomerRepository.save(entity);
        }





    private CustomerDTO mapToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setUser(customer.getUser());
        customerDTO.setPassword(customer.getPassword());
        return customerDTO;
    }


}
