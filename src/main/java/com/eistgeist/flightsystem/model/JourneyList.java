package com.eistgeist.flightsystem.model;

import lombok.Data;

import java.util.List;

@Data
public class JourneyList {
    private List<Journey> journeyList;

    public boolean insertJourney(Journey journey) {
        return journeyList.add(journey);
    }
}

