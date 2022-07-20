package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Weather;
import com.eistgeist.flightsystem.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping("weather/{cityName}")
    public ResponseEntity<Weather> getWeather(@PathVariable String cityName) {
        Weather weather = weatherService.getWeather(cityName);
        if(weather == null) return new ResponseEntity<>(null, HttpStatus.valueOf(402));
        return ResponseEntity.ok(weather);
    }

}
