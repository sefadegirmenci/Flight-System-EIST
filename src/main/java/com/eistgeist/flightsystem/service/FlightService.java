package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.FlightNotFoundException;
import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FlightService {

    private FlightRepository flightRepository;


    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }
    public Flight searchFlight(Airport departureAirport, Airport arrivalAirport) {
        return flightRepository.findFlightsByArrivalAirportIgnoreCaseAndDepartureAirportIgnoreCase(departureAirport, arrivalAirport)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }


}
