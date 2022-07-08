package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirportService {
    private AirportRepository airportRepository;
    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }
}
