package com.eistgeist.flightsystem.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {
    private String name;
    private List<Coupon> coupons;
    private List<POI> POIList;

    /* TODO: Consider this to change journey instead of flight */
    private List<Flight> flightList; /* The flights that user saved */

    public User(String name) {
        this.name = name;
        this.coupons = new ArrayList<>();
        this.POIList = new ArrayList<>();
        this.flightList = new ArrayList<>();
    }
    /* TODO: Add these use cases to the service layer
    public void savePOI(POI poi) {
        this.POIList.add(poi);
    }
    public void receiveCoupon(Coupon coupon) {
        this.coupons.add(coupon);
    }
    public void saveFlight(Flight flight) {
        this.flightList.add(flight);
    }

     */

}
