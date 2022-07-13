package com.eistgeist.flightsystem.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.net.URL;

enum Category{
    FOOD,
    DRINK
}
/**
 * This item can be a food, drink etc.
 */
@Data
@Document
public class Item implements Serializable {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String name;
    private float price;
    private URL imageURL;
    private Category category;

}
