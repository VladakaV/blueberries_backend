package com.example.demo.Services;

import com.example.demo.Entity.User;

public interface UserService {

    public User registerUser(String login, String password);
    public User findByLogin(String login);

}
