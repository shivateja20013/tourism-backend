package com.tourism.backend.repository;

import com.tourism.backend.entity.Activity;
import com.tourism.backend.entity.Hotel;
import com.tourism.backend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findByHotelIdAndIsActive(Long id, Boolean isActive);
    List<Hotel> findByPlaceAndIsActive(Place place, Boolean isActive);
    List<Hotel> findByIsActive(Boolean isActive);
}
