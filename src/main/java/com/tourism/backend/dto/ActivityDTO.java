package com.tourism.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    private Long activityId;
    private Long placeId;
    private Long entryFee;
    private String activityName;
    private String description;
    private Boolean isActive = true;
}
