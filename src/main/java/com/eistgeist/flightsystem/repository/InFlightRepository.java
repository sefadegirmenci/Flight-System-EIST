package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InFlightRepository extends MongoRepository<Item, String> {
    Optional<Item> findItemByName(String name);
}
