package com.eistgeist.flightsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Coupon> coupons;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<POI> POIList;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ArrayList<Journey> journeys; /* The flights that user saved */

    public User() {

    }

    public User(String userName, String password, List<Coupon> coupons,List<POI> POIList, ArrayList<Journey> journeys ) {
        this.userName = userName;
        this.password = password;
        this.coupons = coupons;
        this.POIList = POIList;
        this.journeys = journeys;
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
