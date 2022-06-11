package com.eistgeist.flightsystem.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Flight implements Serializable {
    private String departureAirport;
    private String arrivalAirport;
    private int flightID;

    public Flight(int flightID,
                  String airline,
                  String departureAirport,
                  String arrivalAirport
                  ) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightID = flightID;
    }


    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    @Override
    public String toString() {
        return "Flight{" +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", flightID=" + flightID +
                '}';
    }
}
