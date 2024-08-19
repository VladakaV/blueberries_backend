package com.example.demo.Services;

import com.example.demo.Entity.Reviews;
import com.example.demo.Repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ReviewsService {
    public Iterable<Reviews> findAll();
}
