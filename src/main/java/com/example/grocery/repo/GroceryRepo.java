package com.example.grocery.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.grocery.model.GroceryItem;

@Repository
public class GroceryRepo {
    List<GroceryItem> groceryItems = new ArrayList<>(
        Arrays.asList(
            new GroceryItem(1,"Milk","Dairy",25.00),
            new GroceryItem(2,"Bread","Bakery",40.00),
            new GroceryItem(3,"Egg","Nonveg",10.00),
            new GroceryItem(4,"Flour","cerials",50.00)
        )
    );
    public List<GroceryItem> getAllItems()
    {
        return groceryItems;
    }
    public void addItems(GroceryItem item)
    {
      groceryItems.add(item);
    }
    public GroceryItem getItems( int pid) {
        for(GroceryItem item:groceryItems)
        {
          if(item.getPid()==pid)
          {
            return item;
          }
        }
        return null;
    }


    
}
