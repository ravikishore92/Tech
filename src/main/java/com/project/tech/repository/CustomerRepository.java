package com.project.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tech.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
