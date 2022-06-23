package com.eistgeist.flightsystem.repository;


import com.eistgeist.flightsystem.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CityRepository
        extends MongoRepository<City, String> {
    Optional<City> findCityByName();
}
