package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Item;
import com.eistgeist.flightsystem.service.InFlightService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@AllArgsConstructor
@RequestMapping("inflight")
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
    @GetMapping("search/{name}")
    public ResponseEntity<Item> searchItem(@PathVariable String name) {
        return ResponseEntity.ok(inFlightService.searchItem(name));
    }
}
