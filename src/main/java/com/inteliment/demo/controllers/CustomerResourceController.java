package com.inteliment.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inteliment.demo.models.Customer;
import com.inteliment.demo.repositories.CustomerRepository;

@RestController
public class CustomerResourceController {
	
	@Autowired
	CustomerRepository repository;
	@RequestMapping(path="/customer",method=RequestMethod.POST)
	Customer save(){
		
		Customer customer= repository.save(new Customer("Jack", "Bauer"));
		System.out.println(customer);
		Customer customer2=repository.findById(customer.getId()).get();
		System.out.println(customer2);
		return customer2;
	} 
	@RequestMapping(path="/customers",method=RequestMethod.GET)
	Iterable<Customer> get(){
		return repository.findAll();
	} 

}
