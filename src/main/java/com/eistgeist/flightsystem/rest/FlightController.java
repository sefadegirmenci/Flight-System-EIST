package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Flight>> getFlights(){
        return ResponseEntity.ok(flightService.getFlights());
    }

    @PostMapping("flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return ResponseEntity.ok(flightService.addFlight(flight));
    }

}
