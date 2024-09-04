package com.tourism.backend.repository;

import com.tourism.backend.entity.Activity;
import com.tourism.backend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Activity findByActivityIdAndIsActive(Long id, Boolean isActive);
    List<Activity> findByPlaceAndIsActive(Place place, Boolean isActive);
    List<Activity> findByIsActive(Boolean isActive);
}
