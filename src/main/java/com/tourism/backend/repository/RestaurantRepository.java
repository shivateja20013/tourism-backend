package com.tourism.backend.repository;

import com.tourism.backend.entity.Activity;
import com.tourism.backend.entity.Place;
import com.tourism.backend.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByPlaceAndIsActive(Place place, Boolean isActive);
    Restaurant findByRestaurantIdAndIsActive(Long id, Boolean isActive);
    List<Restaurant> findByIsActive(Boolean isActive);
}