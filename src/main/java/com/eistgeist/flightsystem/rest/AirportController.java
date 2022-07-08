package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
@CrossOrigin
public class AirportController {
    AirportService airportService;

    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.addAirport(airport));
    }
}
