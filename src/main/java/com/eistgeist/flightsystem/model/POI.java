package com.eistgeist.flightsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class POI {
    double xCoordinate;
    double yCoordinate;

    public POI(){}
}
