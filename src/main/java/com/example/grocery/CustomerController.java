package com.example.grocery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocery.model.Customer;
import com.example.grocery.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
 public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }
    @PostMapping("/")
    public void addCustomer(@RequestBody Customer customer)
    {
      customerService.addCustomer(customer);;
    }
    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
      return customerService.getCustomer(customerId);
  }
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId)
    {
        customerService.deleteCustomer(customerId);;
        
    }
  
}
