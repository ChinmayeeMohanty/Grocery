package com.example.grocery.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.grocery.model.GroceryItem;

import jakarta.transaction.Transactional;

@Repository
public interface GroceryRepo extends JpaRepository<GroceryItem,Integer>{
   
    @Modifying
    @Transactional
    @Query("UPDATE GroceryItem g SET g.stocks =g.stocks - :quantity WHERE g.pid=:pid AND g.stocks >= :quantity") 
    int reduceStock(@Param("pid") int pid,@Param("quantity") int quantity);

    Optional<GroceryItem> findByCatagory(String catagory); 
    
    Optional<GroceryItem> findByPrice(double price);

    
}
