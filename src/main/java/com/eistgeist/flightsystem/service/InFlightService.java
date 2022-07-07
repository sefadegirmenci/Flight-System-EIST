package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.exception.ItemNotFoundException;
import com.eistgeist.flightsystem.model.Item;
import com.eistgeist.flightsystem.repository.InFlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InFlightService {
    private InFlightRepository inFlightRepository;

    public List<Item> getItems() {
        return inFlightRepository.findAll();
    }
    public Item addItem(Item item) {
        return inFlightRepository.save(item);
    }
    public Item searchItem(String name) {
        return inFlightRepository.findItemByName(name).orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }
}
