package com.example.demo.Services;

import com.example.demo.Entity.Reviews;
import com.example.demo.Repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public interface ReviewsService {
    public Iterable<Reviews> findAll();

    public Reviews saveReview(Reviews review);
}
