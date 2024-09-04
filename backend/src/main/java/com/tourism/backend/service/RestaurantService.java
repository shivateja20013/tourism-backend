package com.tourism.backend.service;

import com.tourism.backend.dto.RestaurantDTO;
import com.tourism.backend.entity.Place;
import com.tourism.backend.entity.Restaurant;
import com.tourism.backend.repository.PlaceRepository;
import com.tourism.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private PlaceRepository placeRepository;

    public Restaurant createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
        restaurant.setPlace(this.placeRepository.findById(restaurantDTO.getPlaceID()).orElseThrow());
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setDescription(restaurantDTO.getDescription());
        restaurant.setMinPrice(restaurantDTO.getMinPrice());
        restaurant.setMaxPrice(restaurantDTO.getMaxPrice());
        restaurant.setCuisine(restaurantDTO.getCuisine());
        restaurant.setRating(restaurantDTO.getRating());
        return this.restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return this.restaurantRepository.findByRestaurantIdAndIsActive(restaurantId, true);
    }

    public List<Restaurant> getRestaurantsByPlace(Long placeId) {
        return this.restaurantRepository.findByPlaceAndIsActive(this.placeRepository.findById(placeId).orElseThrow(), true);
    }

    public Restaurant updateRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
        restaurant.setPlace(this.placeRepository.findById(restaurantDTO.getPlaceID()).orElseThrow());
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setDescription(restaurantDTO.getDescription());
        restaurant.setMinPrice(restaurantDTO.getMinPrice());
        restaurant.setMaxPrice(restaurantDTO.getMaxPrice());
        restaurant.setCuisine(restaurantDTO.getCuisine());
        restaurant.setRating(restaurantDTO.getRating());
        return this.restaurantRepository.save(restaurant);
    }

    public Restaurant deleteRestaurant(Long id) {
        Restaurant restaurant = this.restaurantRepository.findById(id).orElseThrow();
        restaurant.setIsActive(false);
        return this.restaurantRepository.save(restaurant);
    }
}