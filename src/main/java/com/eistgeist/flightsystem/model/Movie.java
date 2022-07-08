package com.eistgeist.flightsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.net.URL;

@Data
@Document
public class Movie {
        @Id
        private String id;
        private String name;
        private String description;
        private URL thumbnailURL;
}
