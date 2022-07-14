package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository
        extends MongoRepository<Flight,String> {
    Optional<List<Flight>> findFlightsByArrivalAirportIgnoreCaseAndDepartureAirportIgnoreCaseAndDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual (Airport arrivalAirport, Airport departureAirport, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime);
}
