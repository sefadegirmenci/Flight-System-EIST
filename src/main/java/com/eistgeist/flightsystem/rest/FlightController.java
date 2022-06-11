package com.eistgeist.flightsystem.controller;

import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("flights")
    public List<Flight> getFlights(){
        return flightService.getFlights();
    }

    @PostMapping()
    public void addFlight(Flight flight){
        return flightService.addFlight(flight);
    }
}
