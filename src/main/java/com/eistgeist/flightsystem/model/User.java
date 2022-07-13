package com.eistgeist.flightsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value ="USERNAME",required = true)
    private String userName;
    @JsonProperty(value ="PASSWORD",required = true)
    private String password;
    @JsonProperty(value ="COUPONS",required = false)
    private List<Coupon> coupons;
    @JsonProperty(value ="POILIST",required = false)

    private List<POI> POIList;
    @JsonProperty(value ="JOURNEYS",required = false)
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
