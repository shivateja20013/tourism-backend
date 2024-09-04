package com.tourism.backend.repository;

import com.tourism.backend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByPlaceIdAndIsActive(Long id, Boolean isActive);
    Place findByPlaceNameAndIsActive(String placeName, Boolean isActive);
    List<Place> findByIsActive(Boolean isActive);
}
