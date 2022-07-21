package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.model.Journey;
import com.eistgeist.flightsystem.model.User;
import com.eistgeist.flightsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User addJourney(Journey journey, String userName) {
        User user = userRepository.findUserByUserNameIgnoreCase(userName).orElseThrow(() -> new IllegalStateException("User not found"));
        ArrayList<Journey> journeys = user.getJourneys();
        if(journeys == null) {
            journeys = new ArrayList<>();
        }
        journeys.add(journey);
        user.setJourneys(journeys);
        return userRepository.save(user);
    }
}
