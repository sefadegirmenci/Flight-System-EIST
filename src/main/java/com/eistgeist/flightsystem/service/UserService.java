package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.model.User;
import com.eistgeist.flightsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User addUser(String userName, String password) {
        User user = new User(userName,password);
        return userRepository.save(user);
    }
}
