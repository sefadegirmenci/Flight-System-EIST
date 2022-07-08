package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.ItemNotFoundException;
import com.eistgeist.flightsystem.exception.MovieNotFoundException;
import com.eistgeist.flightsystem.model.Item;
import com.eistgeist.flightsystem.model.Movie;
import com.eistgeist.flightsystem.repository.InFlightRepository;
import com.eistgeist.flightsystem.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InFlightService {
    private InFlightRepository inFlightRepository;
    private MovieRepository movieRepository;
    public List<Item> getItems() {
        return inFlightRepository.findAll();
    }
    public Item addItem(Item item) {
        return inFlightRepository.save(item);
    }
    public Item searchItem(String name) {
        return inFlightRepository.findItemByName(name).orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public Movie searchMovie(String name) {
        return movieRepository.findMovieByName(name).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
    }

}
