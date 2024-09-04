package com.tourism.backend.controller;

import com.tourism.backend.dto.RestaurantDTO;
import com.tourism.backend.entity.Restaurant;
import com.tourism.backend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant createdRestaurant = this.restaurantService.createRestaurant(restaurantDTO);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByPlace(@PathVariable Long placeId) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsByPlace(placeId);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantDTO);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable Long restaurantId) {
        Restaurant deletedRestaurant = restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<>(deletedRestaurant, HttpStatus.OK);
    }
}
