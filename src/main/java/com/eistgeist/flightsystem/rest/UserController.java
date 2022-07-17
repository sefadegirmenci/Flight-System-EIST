package com.eistgeist.flightsystem.rest;

import com.eistgeist.flightsystem.model.Journey;
import com.eistgeist.flightsystem.model.User;
import com.eistgeist.flightsystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("users")
public class UserController {
    private UserService userService;

    @PostMapping("")
    @Operation(description = "Add a user and its password")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if(user == null) return (ResponseEntity<User>) ResponseEntity.badRequest();
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("")
    @Operation(description = "Get users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("addJourney/{username}")
    public ResponseEntity<User> addJourney(@RequestBody Journey journey, @PathVariable String username) {
        return ResponseEntity.ok(userService.addJourney(journey, username));
    }

}
