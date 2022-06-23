package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.City;
import com.eistgeist.flightsystem.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CityController {
    private CityService cityService;

    @GetMapping("cities")
    public ResponseEntity<List<City>> getCities() {
        return ResponseEntity.ok(cityService.getCities());
    }
}
