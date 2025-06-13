package com.example.grocery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocery.model.GroceryItem;
import com.example.grocery.service.GroceryService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("")
public class GroceryController {
     @Autowired
  private GroceryService groceryService; 
  @GetMapping("/")
  public List<GroceryItem> getAllItems() {
      return groceryService.getAllItems();
  }
  @GetMapping("/id/{pid}")
  public GroceryItem getItems(@PathVariable("pid") int pid) {
      return groceryService.getItems(pid);
  }
  @PostMapping("/add")
  public GroceryItem addItems(@RequestBody GroceryItem item) {
   groceryService.addItems(item);
      return groceryService.getItems(item.getPid());
  }
    @GetMapping("/catagory/{catagory}")
  public GroceryItem getItemsByCatagory(@PathVariable("catagory")String catagory) {
      return groceryService.getItemsByCatagory(catagory);
  }
      @GetMapping("/price/{price}")
public GroceryItem getItemsByPrice(@PathVariable("price") double price) {
    return groceryService.getItemsByPrice(price);
}

 @DeleteMapping("/{pid}")
    public void deleteItem(@PathVariable("pid") int pid) {
        groceryService.deleteItem(pid);
    } 
@PostMapping("/buy/{pid}/{quantity}")
    public String buyItem(@PathVariable("pid") int pid,@PathVariable("quantity") int quantity)
    {
      return groceryService.buyItem(pid,quantity);
    }

//update product by id
@PutMapping("/update/{pid}")
public GroceryItem updateItemById(@PathVariable("pid") int pid, @RequestBody GroceryItem updatedItem) {
    return groceryService.updateItemById(pid, updatedItem);
}
@PatchMapping("/update/{pid}")
public GroceryItem patchItem(@PathVariable("pid") int pid, @RequestBody GroceryItem partialItem) {
    return groceryService.patchItem(pid, partialItem);
}

}
