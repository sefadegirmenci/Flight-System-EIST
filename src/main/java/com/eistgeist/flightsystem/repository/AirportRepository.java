package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AirportRepository extends MongoRepository<Airport, String> {

    Optional<Airport> findAirportByAirportCodeIgnoreCase(String code);
}
