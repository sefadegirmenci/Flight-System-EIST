package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FlightRepository
        extends MongoRepository<Flight,String> {
    Optional<Flight> findFlightsByArrivalAirportIgnoreCaseAndDepartureAirportIgnoreCase(Airport arrivalAirport, Airport departureAirport);
}
