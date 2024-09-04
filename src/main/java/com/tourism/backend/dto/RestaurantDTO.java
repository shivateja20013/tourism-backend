package com.tourism.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private Long restaurantId;
    private Long placeId;
    private String restaurantName;
    private String description;
    private Long minPrice;
    private Long maxPrice;
    private String cuisine;
    private int rating;
    private Boolean isActive = true;
}
