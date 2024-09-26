package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
@CrossOrigin
public class FlightController {
    private final FlightService flightService;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
    @Operation(summary = "Search flights by user specific queries")
    @GetMapping(value = "search",produces = {"application/json"})
    public ResponseEntity<List<Flight>> searchFlights(@RequestParam(value = "departureCode", required = false) Optional<String> departureAirportCode,
                                                      @RequestParam(value = "arrivalCode", required = false) Optional<String> arrivalAirportCode,
                                                      @RequestParam(value = "departureDate",required = false) Optional<String> departureDateTimeString,
                                                      @RequestParam(value = "arrivalDate",required = false) Optional<String> arrivalDateTimeString) {
        LocalDateTime departureDateTime = null;
        LocalDateTime arrivalDateTime = null;
        if(departureDateTimeString.isPresent()) {
            LocalDate departureDate = LocalDate.parse(departureDateTimeString.get(), formatter);
            departureDateTime = departureDate.atStartOfDay();
        }
        if(arrivalDateTimeString.isPresent()) {
            LocalDate arrivalDate = LocalDate.parse(arrivalDateTimeString.get(),formatter);
            arrivalDateTime = arrivalDate.atStartOfDay();
        }

        if(departureAirportCode.isPresent() && arrivalAirportCode.isPresent() && departureDateTimeString.isPresent() && arrivalDateTimeString.isPresent()) {
            return ResponseEntity.ok(flightService.searchFlights(departureAirportCode.get(), arrivalAirportCode.get(), departureDateTime, arrivalDateTime));
        } else if (departureAirportCode.isPresent() && arrivalAirportCode.isPresent() &&
                departureDateTimeString.isEmpty() && arrivalDateTimeString.isEmpty()) {
            return ResponseEntity.ok(flightService.searchFlightsByAirports(departureAirportCode.get(), arrivalAirportCode.get()));
        } else if (departureAirportCode.isPresent() && arrivalAirportCode.isEmpty() &&
                departureDateTimeString.isEmpty() && arrivalDateTimeString.isEmpty()) {
            return ResponseEntity.ok(flightService.searchFlightsByDepartureAirport(departureAirportCode.get()));
        } else if (departureAirportCode.isEmpty() && arrivalAirportCode.isPresent() &&
                departureDateTimeString.isEmpty() && arrivalDateTimeString.isEmpty()) {
            return ResponseEntity.ok(flightService.searchFlightsByArrivalAirport(arrivalAirportCode.get()));
        } else if (departureAirportCode.isEmpty() && arrivalAirportCode.isEmpty() &&
                departureDateTimeString.isPresent() && arrivalDateTimeString.isPresent()) {
            return ResponseEntity.ok(flightService.searchFlightsByDateTimes(departureDateTime, arrivalDateTime));
        } else if (departureAirportCode.isEmpty() && arrivalAirportCode.isEmpty() && departureDateTimeString.isPresent()) {
            return ResponseEntity.ok(flightService.searchFlightsByDepartureTime(departureDateTime));
        } else if (departureAirportCode.isEmpty() && arrivalAirportCode.isEmpty() && arrivalDateTimeString.isPresent()) {
            return ResponseEntity.ok(flightService.searchFlightsByArrivalTime(arrivalDateTime));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Search a flight by ID")
    @GetMapping(value = "search/{id}",produces = {"application/json"})
    public ResponseEntity<Flight> searchFlightByID(@PathVariable String id) {
        return ResponseEntity.ok(flightService.searchFlightById(id));
    }

    @Operation(summary = "Search a flight by ID")
    @GetMapping(value = "v1/explore-lists/{id}",produces = {"application/json"})
    public ResponseEntity<ExploreListMetadataDto> exploreList(@PathVariable String id) {
        return ResponseEntity.ok(flightService.explore(id));
    }



}
