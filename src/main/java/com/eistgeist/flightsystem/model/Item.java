package com.eistgeist.flightsystem.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;

/**
 * This item can be a food, drink etc.
 */
@Data
@Document
public class Item {
    @Id
    private String id;
    private String name;
    private float price;
    private URL imageURL;
}