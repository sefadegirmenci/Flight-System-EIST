package com.eistgeist.flightsystem.service;

import com.eistgeist.flightsystem.model.Item;
import com.eistgeist.flightsystem.repository.MenuRepository;
import com.eistgeist.flightsystem.rest.MenuController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {
    private MenuRepository menuRepository;
    public List<Item> getItems() {
        return menuRepository.findAll();
    }
}
