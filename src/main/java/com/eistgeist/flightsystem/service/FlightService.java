package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.FlightNotFoundException;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.repository.AirportRepository;
import com.eistgeist.flightsystem.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FlightService {

    private FlightRepository flightRepository;
    private AirportRepository airportRepository;

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> searchFlight(String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        return flightRepository.findFlightsByDepartureAirportAirportCodeIgnoreCaseAndArrivalAirportAirportCodeIgnoreCaseAndDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual
                        (departureAirportCode, arrivalAirportCode, departureDateTime, arrivalDateTime)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }

    public List<Flight> searchFlightByAirports(String departureAirportCode, String arrivalAirportCode) {
        return flightRepository.findFlightsByDepartureAirportAirportCodeIgnoreCaseAndArrivalAirportAirportCodeIgnoreCase(departureAirportCode, arrivalAirportCode)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }


    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}
