package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<Flight,String> {
}
