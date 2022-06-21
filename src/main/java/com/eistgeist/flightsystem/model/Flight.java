package com.eistgeist.flightsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A class that is used for single instance of flights.
 * This class is the base for mongodb flight document.
 */
@Data
@Document
public class Flight implements Serializable {
    /* Not all the fields are added so that we first have a simpler code */
    @Id
    private String id;
    private int flightNumber;
    private Airport arrivalAirport;
    private Airport departureAirport;

    public Flight(int flightNumber, Airport arrivalAirport, Airport departureAirport) {
        this.flightNumber = flightNumber;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }
}
