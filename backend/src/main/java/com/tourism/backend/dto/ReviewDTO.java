package com.tourism.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long reviewId;
    private Long placeID;
    private Long activityID;
    private Long hotelID;
    private Long restaurantID;
    private String username;
    private int rating;
    private String comment;
    private Boolean isActive = true;
}
