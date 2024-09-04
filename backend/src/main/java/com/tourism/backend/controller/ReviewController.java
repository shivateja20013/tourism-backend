package com.tourism.backend.controller;

import com.tourism.backend.dto.ReviewDTO;
import com.tourism.backend.entity.Review;
import com.tourism.backend.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO reviewDTO) {
        Review createdReview = this.reviewService.createReview(reviewDTO);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Review>> getReviewsByPlace(@PathVariable Long placeId) {
        List<Review> reviews = reviewService.getReviewsByPlace(placeId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Review>> getReviewsByActivity(@PathVariable Long activityId) {
        List<Review> reviews = reviewService.getReviewsByActivity(activityId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Review>> getReviewsByHotel(@PathVariable Long hotelId) {
        List<Review> reviews = reviewService.getReviewsByHotel(hotelId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Review>> getReviewsByRestaurant(@PathVariable Long restaurantId) {
        List<Review> reviews = reviewService.getReviewsByRestaurant(restaurantId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable String username) {
        List<Review> reviews = reviewService.getReviewsByUser(username);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long reviewId) {
        Review review = reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}
