package com.tourism.backend.service;

import com.tourism.backend.dto.ActivityDTO;
import com.tourism.backend.entity.Activity;
import com.tourism.backend.repository.ActivityRepository;
import com.tourism.backend.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private PlaceRepository placeRepository;

    public Activity createActivity(ActivityDTO activityDTO){
        Activity activity = new Activity();
        activity.setActivityId(activityDTO.getActivityId());
        activity.setPlace(this.placeRepository.findById(activityDTO.getPlaceId()).orElseThrow());
        activity.setEntryFee(activityDTO.getEntryFee());
        activity.setActivityName(activityDTO.getActivityName());
        activity.setDescription(activityDTO.getDescription());
        return this.activityRepository.save(activity);
    }

    public Activity getActivityById(Long activityId){
        return this.activityRepository.findByActivityIdAndIsActive(activityId, true);
    }

    public List<Activity> getActivitiesByIsActive(){
        return this.activityRepository.findByIsActive(true);
    }

    public List<Activity> getActivitiesByPlace(Long placeId){
        return this.activityRepository.findByPlaceAndIsActive(this.placeRepository.findById(placeId).orElseThrow(), true);
    }

    public Activity updateActivity(ActivityDTO activityDTO){
        Activity activity = new Activity();
        activity.setActivityId(activityDTO.getActivityId());
        activity.setPlace(this.placeRepository.findById(activityDTO.getPlaceId()).orElseThrow());
        activity.setEntryFee(activityDTO.getEntryFee());
        activity.setActivityName(activityDTO.getActivityName());
        activity.setDescription(activityDTO.getDescription());
        return this.activityRepository.save(activity);
    }

    public Activity deleteActivity(Long id){
        Activity activity = this.activityRepository.findById(id).orElseThrow();
        activity.setIsActive(false);
        return this.activityRepository.save(activity);
    }
}
