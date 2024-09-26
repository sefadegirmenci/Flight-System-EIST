package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.FlightNotFoundException;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.repository.AirportRepository;
import com.eistgeist.flightsystem.repository.FlightRepository;
import com.eistgeist.flightsystem.rest.ExploreListMetadataDto;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Flight> searchFlights(String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        return flightRepository.findFlightsByDepartureAirportAirportCodeIgnoreCaseAndArrivalAirportAirportCodeIgnoreCaseAndDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual
                        (departureAirportCode, arrivalAirportCode, departureDateTime, arrivalDateTime)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }

    public List<Flight> searchFlightsByAirports(String departureAirportCode, String arrivalAirportCode) {
        return flightRepository.findFlightsByDepartureAirportAirportCodeIgnoreCaseAndArrivalAirportAirportCodeIgnoreCase(departureAirportCode, arrivalAirportCode)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }

    public List<Flight> searchFlightsByDepartureAirport(String departureAirportCode) {
        return flightRepository.findFlightsByDepartureAirportAirportCodeIgnoreCase(departureAirportCode)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }

    public List<Flight> searchFlightsByArrivalAirport(String arrivalAirportCode) {
        return flightRepository.findFlightsByArrivalAirportAirportCodeIgnoreCase(arrivalAirportCode)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }
    public List<Flight> searchFlightsByDateTimes(LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        return flightRepository.findFlightsByDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual(departureDateTime, arrivalDateTime)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }

    public List<Flight> searchFlightsByDepartureTime(LocalDateTime departureDateTime) {
        return flightRepository.findFlightsByDepartureDateTimeGreaterThanEqual(departureDateTime)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }
    public List<Flight> searchFlightsByArrivalTime(LocalDateTime arrivalDateTime) {
        return flightRepository.findFlightsByArrivalDateTimeLessThanEqual(arrivalDateTime)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }
    public Flight searchFlightById(String id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found"));
    }

    public ExploreListMetadataDto explore(String id) {
        return null;
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}
