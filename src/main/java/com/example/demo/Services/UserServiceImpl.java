package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password); // В реальном проекте пароль нужно хешировать
        user.setAdmin(false);
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
