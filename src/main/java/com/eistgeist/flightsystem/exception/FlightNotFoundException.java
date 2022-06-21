package com.eistgeist.flightsystem.exception;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(String flight_not_found) {
        super(flight_not_found);
    }
}
