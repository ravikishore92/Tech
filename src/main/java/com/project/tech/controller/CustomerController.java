package com.project.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.tech.entity.Customer;
import com.project.tech.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@PostMapping("post")
	public ResponseEntity<?>setData(@RequestBody Customer c) {
		
		customerRepo.save(c);
		return ResponseEntity.ok().body("Data inserted Successfully");
	}
	
	@GetMapping("get")
	public ResponseEntity<?>getData() {
		
		List<Customer> c = customerRepo.findAll();
		
		return ResponseEntity.ok().body(customerRepo.findAll());
		
	}
	
	@Transactional
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?>deleteCustomer(@PathVariable("id") Long id) {
		customerRepo.deleteById(id);
		
		return ResponseEntity.ok().body("deleted");
	}

}
