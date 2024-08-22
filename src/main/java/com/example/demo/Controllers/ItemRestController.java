package com.example.demo.Controllers;

import com.example.demo.Entity.Item;
import com.example.demo.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:5173")
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/fetchItems")
    public Iterable<Item> fetchItems() {
        return itemService.fetchItems();
    }
}
