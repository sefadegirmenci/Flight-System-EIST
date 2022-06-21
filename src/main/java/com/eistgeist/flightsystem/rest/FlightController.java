package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("flights")
    public ResponseEntity<List<Flight>> getFlights(){
        return ResponseEntity.ok(flightService.getFlights());
    }

    /*@PostMapping("flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return ResponseEntity.ok(flightService.addFlight(flight));
    }*/
    @GetMapping(value = "searchFlight/{departurAirport}/{arrivalAirport}",produces = {"application/json"})
    public ResponseEntity<Flight> searchFlight(@PathVariable Airport departurAirport, @PathVariable Airport arrivalAirport) {
        return ResponseEntity.ok(flightService.searchFlight(departurAirport, arrivalAirport));
    }

}
