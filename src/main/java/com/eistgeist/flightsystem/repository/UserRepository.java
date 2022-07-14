package com.eistgeist.flightsystem.repository;

import com.eistgeist.flightsystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findDistinctByUserByUserNameIgnoreCase(String userName);
}
