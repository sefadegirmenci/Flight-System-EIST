package com.eistgeist.flightsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class JourneyList {
    private List<String> journeyList; // List of flight numbers

    public JourneyList() {
        this.journeyList = new ArrayList<>();
    }

    public boolean insertJourney(String journey) {
        return journeyList.add(journey);
    }
}

