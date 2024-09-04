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
    private Long placeId;
    private Long activityId;
    private Long hotelId;
    private Long restaurantId;
    private String image;
    private Boolean isActive = true;
}
