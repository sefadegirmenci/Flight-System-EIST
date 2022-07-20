package com.eistgeist.flightsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private double temp_c;
    @JsonProperty("condition")
    private WeatherCondition condition;
    private double wind_mph;
    private String wind_dir;
    private double humidity;
    private double feelslike_c;
    private double uv;
}
