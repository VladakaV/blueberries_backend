package com.example.demo.Services;

import com.example.demo.Entity.Marks;
import com.example.demo.Repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarksServiceImpl implements MarksService {
    @Autowired
    private MarksRepository marksRepository;

    public Iterable<Marks> getMarks() {
        return marksRepository.findAll();
    }
}
