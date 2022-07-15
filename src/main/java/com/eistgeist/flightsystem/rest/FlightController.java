package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Operation(summary = "Add a flight")
    @PostMapping("flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return new ResponseEntity<>(flightService.addFlight(flight), HttpStatus.CREATED);
    }

    /* TODO: Change the search logic*/
    @Operation(summary = "Search a flight by all the fields")
    @GetMapping(value = "search/{departureAirportCode}/{arrivalAirportCode}/{departureDateTimeString}/{arrivalDateTimeString}",produces = {"application/json"})
    public ResponseEntity<List<Flight>> searchFlight(@PathVariable(required = false) String departureAirportCode,
                                                     @PathVariable(required = false) String arrivalAirportCode,
                                                     @PathVariable String departureDateTimeString,
                                                     @PathVariable String arrivalDateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate departureDate = LocalDate.parse(departureDateTimeString, formatter);
        LocalDate arrivalDate = LocalDate.parse(arrivalDateTimeString,formatter);
        LocalDateTime departureDateTime = departureDate.atStartOfDay();
        LocalDateTime arrivalDateTime = arrivalDate.atStartOfDay();
        return ResponseEntity.ok(flightService.searchFlight(departureAirportCode, arrivalAirportCode, departureDateTime, arrivalDateTime));
    }

    @Operation(summary = "Search a flight by departure and arrival airports")
    @GetMapping(value = "search/{departureAirportCode}/{arrivalAirportCode}",produces = {"application/json"})
    public ResponseEntity<List<Flight>> searchFlightByAirports(@PathVariable(required = false) String departureAirportCode,
                                                     @PathVariable(required = false) String arrivalAirportCode) {
        return ResponseEntity.ok(flightService.searchFlightByAirports(departureAirportCode, arrivalAirportCode));
    }



}
