package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
@CrossOrigin
public class FlightController {
    private final FlightService flightService;

    @Operation(summary = "Get all the flights")
    @GetMapping("flights")
    public ResponseEntity<List<Flight>> getFlights(){
        return ResponseEntity.ok(flightService.getFlights());
    }

    @Operation(summary = "Put a flight")
    @PostMapping("flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return new ResponseEntity<>(flightService.addFlight(flight), HttpStatus.CREATED);
    }

    /* TODO: Change the search logic*/
    @Operation(summary = "Search a flight by departure and arrival airports")
    @GetMapping(value = "search/{departureAirport}/{arrivalAirport}",produces = {"application/json"})
    public ResponseEntity<Flight> searchFlight(@PathVariable Airport departureAirport, @PathVariable Airport arrivalAirport) {
        return ResponseEntity.ok(flightService.searchFlight(departureAirport, arrivalAirport));
    }

}
