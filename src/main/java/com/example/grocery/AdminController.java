package com.example.grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.grocery.service.GroceryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AdminController {
    @Autowired
    private GroceryService groceryService;

    @GetMapping("/admin")
    public String listItems(Model model)
    {
      model.addAttribute("groceryItems",groceryService.getAllItems());
      return "admin/list";
    }
    
    
}
