package com.example.demo.Services;

import com.example.demo.Entity.Reviews;
import com.example.demo.Repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public Iterable<Reviews> findAll() {
        return reviewsRepository.findAll();
    }
}
