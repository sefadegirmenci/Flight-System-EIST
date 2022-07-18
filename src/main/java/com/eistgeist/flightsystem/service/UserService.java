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

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User addJourney(Journey journey, String userName) {
        User user = userRepository.findUserByUserNameIgnoreCase(userName).orElseThrow(() -> new IllegalStateException("User not found"));
        /* TO-DO: Uncomment if the users are duplicated */
        //userRepository.delete(user);
        JourneyList journeys = user.getJourneys();

        if(journey == null) {
            System.out.println("Journeys is null");
        }
        if(journeys.getJourneyList() == null) {
            System.out.println("List of journey is null");
        }

        user.setJourneys(journeys);
        return userRepository.save(user);
    }
}
