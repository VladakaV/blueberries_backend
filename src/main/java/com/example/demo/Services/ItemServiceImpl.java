package com.example.demo.Services;

import com.example.demo.Entity.Item;
import com.example.demo.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Iterable<Item> fetchItems() {
       return itemRepository.findAll();
    }
}
