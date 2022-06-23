package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Item,String> {
}
