package com.tourism.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private Long imageId;
    private Long placeID;
    private Long activityID;
    private Long hotelID;
    private Long restaurantID;
    private String imageUrl;
    private Boolean isActive = true;
}
