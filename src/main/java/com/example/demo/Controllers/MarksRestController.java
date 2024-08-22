package com.example.demo.Controllers;

import com.example.demo.Entity.Marks;
import com.example.demo.Services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/marks")
@CrossOrigin(origins = "http://localhost:5173")
public class MarksRestController {
    @Autowired
    private MarksService marksService;

    @GetMapping("")
    public Iterable<Marks> getMarks() {
        return marksService.getMarks();
    }
}
