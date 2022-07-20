package com.eistgeist.flightsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherCondition {
    private String text;
    private String icon;
}
