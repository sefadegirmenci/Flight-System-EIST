package com.eistgeist.flightsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store flight journey of the users.
 * It might include a single flight, returning flight, or multiple flights.
 */
@Data
@AllArgsConstructor
public class Journey {
    private List<String> journey;

    public Journey() {
        this.journey = new ArrayList<>();
    }
}
