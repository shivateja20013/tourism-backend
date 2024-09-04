package com.tourism.backend.controller;

import com.tourism.backend.dto.ActivityDTO;
import com.tourism.backend.entity.Activity;
import com.tourism.backend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody ActivityDTO activityDTO) {
        Activity createdActivity = this.activityService.createActivity(activityDTO);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities(){
        List<Activity> activities = activityService.getActivitiesByIsActive( );
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long activityId) {
        Activity activity = activityService.getActivityById(activityId);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Activity>> getActivitiesByPlace(@PathVariable Long placeId) {
        List<Activity> activities = activityService.getActivitiesByPlace(placeId);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Activity> updateActivity(@RequestBody ActivityDTO activityDTO) {
        Activity updatedActivity = activityService.updateActivity(activityDTO);
        return updatedActivity != null ? ResponseEntity.ok(updatedActivity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {
        Activity deletedActivity = activityService.deleteActivity(activityId);
        return deletedActivity != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
