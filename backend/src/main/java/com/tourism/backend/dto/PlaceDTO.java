package com.tourism.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {
    private Long placeId;
    private String placeName;
    private String description;
    private Long entryFee;
    private String city;
    private String district;
    private String state;
    private String country;
    private String pincode;
    private String mapLink;
    private Boolean isActive = true;
}
