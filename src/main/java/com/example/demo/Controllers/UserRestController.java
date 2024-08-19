package com.example.demo.Controllers;

import com.example.demo.Entity.Item;
import com.example.demo.Entity.Marks;
import com.example.demo.Entity.Reviews;
import com.example.demo.Entity.User;
import com.example.demo.Services.ItemService;
import com.example.demo.Services.MarksService;
import com.example.demo.Services.ReviewsService;
import com.example.demo.Services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private MarksService marksService;
    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.findByLogin(user.getLogin()) != null) {
            return ResponseEntity.badRequest().body("Логин уже занят");
        }
        userService.registerUser(user.getLogin(), user.getPassword());
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        User foundUser = userService.findByLogin(user.getLogin());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Вход выполнен успешно");
        }
        else {
            return ResponseEntity.badRequest().body("Неверный логин или пароль");
        }
    }

    @GetMapping("/fetchItems")
    public Iterable<Item> fetchItems() {
        return itemService.fetchItems();
    }

    @GetMapping("/marks")
    public Iterable<Marks> getMarks() {
        return marksService.getMarks();
    }

    @GetMapping("/reviews")
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
