package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private List<Flight> flights=new ArrayList<>();

    public List<Flight> getFlights(){
        return flights;
    }

    public Flight addFlight(Flight flight){
        this.flights.add(flight);
        return flight;
    }


}
