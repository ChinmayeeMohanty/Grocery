package com.example.grocery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grocery.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{
    
}
