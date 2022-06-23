package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Item;
import com.eistgeist.flightsystem.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("inflight-service")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("items")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(menuService.getItems());
    }

}
