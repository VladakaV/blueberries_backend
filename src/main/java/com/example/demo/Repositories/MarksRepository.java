package com.example.demo.Repositories;

import com.example.demo.Entity.Marks;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MarksRepository extends CrudRepository<Marks, Integer> {

    public Optional<Marks> findByItemId(int itemId);

}
