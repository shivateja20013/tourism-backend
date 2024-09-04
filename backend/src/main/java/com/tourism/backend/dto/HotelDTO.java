package com.tourism.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private Long hotelId;
    private Long placeID;
    private String hotelName;
    private String description;
    private Long minPrice;
    private Long maxPrice;
    private int rating;
    private Boolean isActive = true;
}
