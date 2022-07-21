package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.model.City;
import com.eistgeist.flightsystem.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private CityRepository cityRepository;

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    /* TODO: Add map and POI */
}
