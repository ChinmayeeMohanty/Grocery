package com.example.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery.model.GroceryItem;
import com.example.grocery.repo.GroceryRepo;

import jakarta.transaction.Transactional;

@Service
public class GroceryService
{

  @Autowired
  private GroceryRepo groceryRepo;
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
  public void deleteItem(int pid)
  {
    groceryRepo.deleteById(pid);
    System.out.println("Product deleted");
  }
  @Transactional

  public String buyItem(int pid,int quantity)
  {
    int update=groceryRepo.reduceStock(pid, quantity);
    return update>0 ? "Successful buy":"Out of Stock";
    
  }
  
}
