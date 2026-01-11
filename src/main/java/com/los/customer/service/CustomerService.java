package com.los.customer.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.los.customer.entity.Customer;
import com.los.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    
    }

}
