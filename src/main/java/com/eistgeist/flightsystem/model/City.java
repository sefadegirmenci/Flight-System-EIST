package com.eistgeist.flightsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class City {
    /*TODO: Add the fields that will be stored in the database */
    @Id
    private String id;
    private String name;
}
