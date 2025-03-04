package com.example.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery.model.GroceryItem;
import com.example.grocery.repo.GroceryRepo;

@Service
public class GroceryService
{
  @Autowired
  private GroceryRepo groceryRepo;
  public List<GroceryItem> getAllItems()
    {
        return groceryRepo.getAllItems();
    }
    public void addItems(GroceryItem item)
    {
      groceryRepo.addItems(item);
    }
    public GroceryItem getItems( int pid) {
      return groceryRepo.getItems(pid);
  }
  public String deleteItem(int pid)
  {
    return groceryRepo.deleteItem(pid);
  }
  
}
