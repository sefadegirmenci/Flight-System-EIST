package com.eistgeist.flightsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Airport {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String airportCode;
    private String city;

    public Airport(String airportCode, String city) {
        this.airportCode = airportCode;
        this.city = city;
    }
}
