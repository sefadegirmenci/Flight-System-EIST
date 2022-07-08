package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.AirportNotFoundException;
import com.eistgeist.flightsystem.exception.FlightNotFoundException;
import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.repository.AirportRepository;
import com.eistgeist.flightsystem.repository.CityRepository;
import com.eistgeist.flightsystem.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FlightService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }
    public Flight searchFlight(String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        Airport departureAirport = airportRepository.findAirportByAirportCodeIgnoreCase(departureAirportCode)
                .orElseThrow(() -> new AirportNotFoundException("Departure airport not found"));
        Airport arrivalAirport = airportRepository.findAirportByAirportCodeIgnoreCase(arrivalAirportCode)
                .orElseThrow(() -> new AirportNotFoundException("Arrival airport not found"));
        return flightRepository.findFlightsByArrivalAirportIgnoreCaseAndDepartureAirportIgnoreCaseAndDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual(departureAirport, arrivalAirport, departureDateTime, arrivalDateTime)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }


    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}
