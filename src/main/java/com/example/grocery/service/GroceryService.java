package com.example.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery.model.GroceryItem;
import com.example.grocery.repo.GroceryRepo;

@Service
public class GroceryService
{

    private final GroceryItem groceryItem;
  @Autowired
  private GroceryRepo groceryRepo;

    GroceryService(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }
  public List<GroceryItem> getAllItems()
    {
        return groceryRepo.findAll();
    }
    public void addItems(GroceryItem item)
    {
      groceryRepo.save(item);
    }
    public GroceryItem getItems( int pid) {
      return groceryRepo.findById( pid).orElse(null);
  }
  
  
}
