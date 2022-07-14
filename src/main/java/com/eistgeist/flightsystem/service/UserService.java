package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.UserNotFoundException;
import com.eistgeist.flightsystem.model.Journey;
import com.eistgeist.flightsystem.model.User;
import com.eistgeist.flightsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User addJourney(Journey journey, String userName) {
        User user = userRepository.findUserByUserNameIgnoreCase(userName).orElseThrow(() -> new UserNotFoundException("User not found"));
        /* TO-DO: Uncomment if the users are duplicated */
        //userRepository.delete(user);
        List<Journey> journeys = user.getJourneys();
        journeys.add(journey);
        user.setJourneys(journeys);
        return userRepository.save(user);
    }
}
