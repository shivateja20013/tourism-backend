package com.tourism.backend.repository;

import com.tourism.backend.entity.Review;
import com.tourism.backend.entity.Activity;
import com.tourism.backend.entity.Hotel;
import com.tourism.backend.entity.Place;
import com.tourism.backend.entity.Restaurant;
import com.tourism.backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByPlaceAndIsActive(Place place, Boolean isActive);
    List<Review> findByActivityAndIsActive(Activity activity, Boolean isActive);
    List<Review> findByHotelAndIsActive(Hotel hotel, Boolean isActive);
    List<Review> findByRestaurantAndIsActive(Restaurant restaurant, Boolean isActive);
    List<Review> findByUserAndIsActive(User user, Boolean isActive);
}
