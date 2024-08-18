package com.example.demo.Repositories;

import com.example.demo.Entity.Reviews;
import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository extends CrudRepository<Reviews, Integer> {
}
