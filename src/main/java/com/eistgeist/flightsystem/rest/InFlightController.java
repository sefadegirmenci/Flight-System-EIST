package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Item;
import com.eistgeist.flightsystem.model.Movie;
import com.eistgeist.flightsystem.service.InFlightService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("inflight")
@CrossOrigin
public class InFlightController {
    private InFlightService inFlightService;
    @Operation(summary = "Get all the items on the menu")
    @GetMapping("items")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(inFlightService.getItems());
    }

    @Operation(summary = "Add an item")
    @PostMapping("items")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(inFlightService.addItem(item));
    }

    @Operation(summary = "Find item details by its name")
    @GetMapping("items/{name}")
    public ResponseEntity<Item> searchItem(@PathVariable String name) {
        return ResponseEntity.ok(inFlightService.searchItem(name));
    }

    @Operation(summary = "Get all the movies")
    @GetMapping("movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(inFlightService.getMovies());
    }

    @Operation(summary = "Add a movie")
    @PostMapping("movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(inFlightService.addMovie(movie));
    }

    @Operation(summary = "Find movie details by its name")
    @GetMapping("movies/{name}")
    public ResponseEntity<Movie> searchMovie(@PathVariable String name) {
        return ResponseEntity.ok(inFlightService.searchMovie(name));
    }


}
