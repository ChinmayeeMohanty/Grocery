package com.example.grocery.model;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
public class GroceryItem {
    private int pid;
    private String name;
    private String catagory;
    private double price;
    
}
