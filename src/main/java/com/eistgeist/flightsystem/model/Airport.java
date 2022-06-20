package com.eistgeist.flightsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

@Data
@AllArgsConstructor
public class Airport {
    private String airportCode;
    private String city;

}
