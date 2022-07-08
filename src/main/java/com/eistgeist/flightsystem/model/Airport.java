package com.eistgeist.flightsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Airport {
    @Id
    private String id;
    private String airportCode;
    private String city;

    public Airport(String airportCode, String city) {
        this.airportCode = airportCode;
        this.city = city;
    }
}
