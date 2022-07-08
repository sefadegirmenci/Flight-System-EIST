package com.eistgeist.flightsystem.exception;

public class AirportNotFoundException extends RuntimeException{

    public AirportNotFoundException(String msg) {
        super(msg);
    }
}
