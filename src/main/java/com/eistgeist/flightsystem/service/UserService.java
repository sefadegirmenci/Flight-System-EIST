package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.FlightNotFoundException;
import com.eistgeist.flightsystem.model.Journey;
import com.eistgeist.flightsystem.model.POI;
import com.eistgeist.flightsystem.model.User;
import com.eistgeist.flightsystem.repository.FlightRepository;
import com.eistgeist.flightsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private FlightRepository flightRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User addJourney(Journey journey, String userName) {
        List<String> flightIDs = journey.getJourney();
        for(String flightID: flightIDs) {
            flightRepository.findById(flightID).orElseThrow(() -> new FlightNotFoundException("Flight not found with id: "+flightID+" "));
        }
        User user = userRepository.findUserByUserNameIgnoreCase(userName).orElseThrow(() -> new IllegalStateException("User not found"));
        ArrayList<Journey> journeys = user.getJourneys();
        if (journeys == null) {
            journeys = new ArrayList<>();
        }
        journeys.add(journey);
        user.setJourneys(journeys);
        return userRepository.save(user);
    }

    public List<Journey> getJourneys(String userName) {
        User user = userRepository.findUserByUserNameIgnoreCase(userName).orElseThrow(() -> new IllegalStateException("User not found"));
        return user.getJourneys();
    }

    public List<POI> getPOIs(String userName) {
        User user = userRepository.findUserByUserNameIgnoreCase(userName).orElseThrow(() -> new IllegalStateException("User not found"));
        return user.getPOIList();
    }
    public User addPOI(POI poi, String userName) {
        User user = userRepository.findUserByUserNameIgnoreCase(userName).orElseThrow(() -> new IllegalStateException("User not found"));
        List<POI> pois = user.getPOIList();
        if (pois == null) {
            pois = new ArrayList<>();
        }
        pois.add(poi);
        user.setPOIList(pois);
        return userRepository.save(user);
    }


}
