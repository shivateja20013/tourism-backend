package com.tourism.backend.repository;

import com.tourism.backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByPlaceAndIsActive(Place place, Boolean isActive);
    List<Image> findByActivityAndIsActive(Activity activity, Boolean isActive);
    List<Image> findByHotelAndIsActive(Hotel hotel, Boolean isActive);
    List<Image> findByRestaurantAndIsActive(Restaurant restaurant, Boolean isActive);
}
