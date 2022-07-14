package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.UserNotFoundException;
import com.eistgeist.flightsystem.model.Journey;
import com.eistgeist.flightsystem.model.JourneyList;
import com.eistgeist.flightsystem.model.User;
import com.eistgeist.flightsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserService.class);

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
        JourneyList journeys = user.getJourneys();
        journeys.insertJourney(journey);
        user.setJourneys(journeys);
        logger.info("User is " + user);
        return userRepository.save(user);
    }
}
