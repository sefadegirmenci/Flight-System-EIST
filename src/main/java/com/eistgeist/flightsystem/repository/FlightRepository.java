package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface FlightRepository
        extends MongoRepository<Flight,String> {
    Optional<Flight> findFlightsByArrivalAirportIgnoreCaseAndDepartureAirportIgnoreCaseAndDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual (Airport arrivalAirport, Airport departureAirport, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime);
}
