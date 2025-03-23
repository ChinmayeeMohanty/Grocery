package com.example.grocery.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grocery.model.GroceryItem;

@Repository
public interface GroceryRepo extends JpaRepository<GroceryItem,Integer>{
   
    
    
}
