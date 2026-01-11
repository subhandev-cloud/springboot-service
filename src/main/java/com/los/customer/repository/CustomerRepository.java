package com.los.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.los.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
