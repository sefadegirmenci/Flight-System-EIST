package com.eistgeist.flightsystem.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JourneyList {
    private List<Journey> journeyList;

    public JourneyList() {
        this.journeyList = new ArrayList<>();
    }

    public boolean insertJourney(Journey journey) {
        return journeyList.add(journey);
    }
}

