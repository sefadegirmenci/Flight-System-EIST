package com.eistgeist.flightsystem;

import com.eistgeist.flightsystem.model.Airport;
import com.eistgeist.flightsystem.model.Flight;
import com.eistgeist.flightsystem.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsystemApplication.class, args);
	}

}
