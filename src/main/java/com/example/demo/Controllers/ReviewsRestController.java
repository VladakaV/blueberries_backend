package com.example.demo.Controllers;

import com.example.demo.Entity.Reviews;
import com.example.demo.Services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewsRestController {

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("")
    public Iterable<Reviews> getReviews() {
        return reviewsService.findAll();
    }

    @PostMapping("/saveReview")
    public ResponseEntity<String> saveReview(@RequestBody Reviews review) {
        if (reviewsService.saveReview(review)!= null) {
            return ResponseEntity.ok().body("Комментарий сохранен");
        }
        else {
            return ResponseEntity.badRequest().body("Комментарий не сохранен");
        }
    }
}
