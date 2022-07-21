package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Flight;
import org.apache.tomcat.jni.Local;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository
        extends MongoRepository<Flight, String> {
    Optional<List<Flight>> findFlightsByDepartureAirportAirportCodeIgnoreCaseAndArrivalAirportAirportCodeIgnoreCaseAndDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual(String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime);
    Optional<List<Flight>> findFlightsByDepartureAirportAirportCodeIgnoreCaseAndArrivalAirportAirportCodeIgnoreCase(String departureAirportCode, String arrivalAirportCode);
    Optional<List<Flight>> findFlightsByDepartureAirportAirportCodeIgnoreCase(String departureAirportCode);
    Optional<List<Flight>> findFlightsByArrivalAirportAirportCodeIgnoreCase(String arrivalAirportCode);
    Optional<List<Flight>> findFlightsByDepartureDateTimeGreaterThanEqual(LocalDateTime departureDateTime);
    Optional<List<Flight>> findFlightsByArrivalDateTimeLessThanEqual(LocalDateTime arrivalDateTime);
    Optional<List<Flight>> findFlightsByDepartureDateTimeGreaterThanEqualAndArrivalDateTimeLessThanEqual(LocalDateTime departureDateTime, LocalDateTime arrivalDateTime);
}
