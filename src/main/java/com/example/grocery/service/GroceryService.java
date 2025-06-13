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

  //Get All Items
  public List<GroceryItem> getAllItems()
    {
        return groceryRepo.findAll();
    }
    //Add item
    public void addItems(GroceryItem item)
    {
      groceryRepo.save(item);
    }
    //Filter By Id
    public GroceryItem getItems( int pid) {
      return groceryRepo.findById( pid).orElse(null);
    }
    //Filter by Category
      public GroceryItem getItemsByCatagory( String catagory) {
      return groceryRepo.findByCatagory( catagory).orElse(null);
    }
    //filter by price
      public GroceryItem getItemsByPrice(double price) {
      return groceryRepo.findByPrice( price).orElse(null);
    }

  //deleter item by id
  public void deleteItem(int pid)
  {
    groceryRepo.deleteById(pid);
    System.out.println("Product deleted");
  }

  //Buy item 
  @Transactional
  public String buyItem(int pid,int quantity)
  {
    int update=groceryRepo.reduceStock(pid, quantity);
    return update>0 ? "Successful buy":"Out of Stock";
    
  }

  public GroceryItem updateItemById(int pid, GroceryItem updatedItem) {
    GroceryItem existingItem = groceryRepo.findById(pid).orElse(null);
    if (existingItem != null) {
        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setStocks(updatedItem.getStocks());
        existingItem.setCatagory(updatedItem.getCatagory());
        return groceryRepo.save(existingItem);
    }
    return null; // or throw a custom exception

}

  public GroceryItem patchItem(int pid, GroceryItem partialItem) {
    GroceryItem existingItem = groceryRepo.findById(pid).orElse(null);
    if (existingItem != null) {
        if (partialItem.getName() != null) {
            existingItem.setName(partialItem.getName());
        }
        if (partialItem.getPrice() != 0.0) {
            existingItem.setPrice(partialItem.getPrice());
        }
        if (partialItem.getStocks() != 0) {
            existingItem.setStocks(partialItem.getStocks());
        }
        if (partialItem.getCatagory() != null) {
            existingItem.setCatagory(partialItem.getCatagory());
        }
        return groceryRepo.save(existingItem);
    }
    return null; // or throw a custom NotFoundException
}

}
