package com.eistgeist.flightsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    //@Indexed(unique = true)
    private String userName;
    private String password;
    private List<Coupon> coupons;
    private List<POI> POIList;

    /* TODO: Consider this to change journey instead of flight */
    private Journey journeys; /* The flights that user saved */

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.coupons = new ArrayList<>();
        this.POIList = new ArrayList<>();
        this.journeys = new Journey();
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
