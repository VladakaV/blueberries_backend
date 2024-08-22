package com.example.demo.Services;

import com.example.demo.Entity.Reviews;
import com.example.demo.Repositories.MarksRepository;
import com.example.demo.Repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Marks;

import java.util.Optional;


@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;
    @Autowired
    private MarksRepository marksRepository;

    public Iterable<Reviews> findAll() {
        return reviewsRepository.findAll();
    }

    public Reviews saveReview(Reviews review) {
        reviewsRepository.save(review);

        // Проверяем, существует ли запись Marks для данного item_id
        Optional<Marks> existingMark = marksRepository.findByItemId(review.getItem_id());

        if (existingMark.isPresent()) {
            // Обновляем существующую запись
            Marks marks = existingMark.get();
            int newCount = marks.getCount_marks() + 1;
            int newRating = (marks.getRating() * marks.getCount_marks() + review.getRating()) / newCount;

            marks.setRating(newRating);
            marks.setCount_marks(newCount);
            marksRepository.save(marks);
        } else {
            // Создаем новую запись
            Marks newMark = new Marks();
            newMark.setItemId(review.getItem_id());
            newMark.setRating(review.getRating());
            newMark.setCount_marks(1);

            marksRepository.save(newMark);
        }

        return review;
    }
}
