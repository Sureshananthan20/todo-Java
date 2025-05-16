package com.example.ToDo_app.service;

import com.example.ToDo_app.model.User;
import com.example.ToDo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User register(User user) {
        return userRepo.save(user);
    }

    public User login(String username, String password) {
        User user = userRepo.findByUsername(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }
}
