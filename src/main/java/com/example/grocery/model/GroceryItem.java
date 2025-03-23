package com.example.grocery.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
@Entity
public class GroceryItem {
    private int stocks;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private String catagory;
    private double price;
    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;
    
}
