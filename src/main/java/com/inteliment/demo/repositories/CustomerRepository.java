package com.inteliment.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inteliment.demo.models.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}