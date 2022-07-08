package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("airport")
public class AirportController {
    AirportService airportService;

    @PostMapping("add")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.addAirport(airport));
    }
}
