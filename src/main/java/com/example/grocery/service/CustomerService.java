package com.example.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery.model.Customer;

import com.example.grocery.repo.CustomerRepo;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public List<Customer> getAllCustomers()
    {
        return customerRepo.findAll();
    }
    public void addCustomer(Customer customer)
    {
      customerRepo.save(customer);
    }
    public Customer getCustomer( int customerId) {
      return customerRepo.findById( customerId).orElse(null);
  }
    public void deleteCustomer(int customerId)
    {
        customerRepo.deleteById(customerId);
        System.out.println("Deleted customer of id " +customerId);
    }
}
