package com.example.demo.Repositories;

import com.example.demo.Entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
