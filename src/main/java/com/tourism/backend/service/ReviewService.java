package com.tourism.backend.service;

import com.tourism.backend.dto.ReviewDTO;
import com.tourism.backend.entity.Activity;
import com.tourism.backend.entity.Hotel;
import com.tourism.backend.entity.Place;
import com.tourism.backend.entity.Restaurant;
import com.tourism.backend.entity.Review;
import com.tourism.backend.entity.User;
import com.tourism.backend.repository.ActivityRepository;
import com.tourism.backend.repository.HotelRepository;
import com.tourism.backend.repository.PlaceRepository;
import com.tourism.backend.repository.RestaurantRepository;
import com.tourism.backend.repository.ReviewRepository;
import com.tourism.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    public Review createReview(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setReviewId(reviewDTO.getReviewId());
        review.setPlace(this.placeRepository.findById(reviewDTO.getPlaceId()).orElseThrow());
        review.setActivity(this.activityRepository.findById(reviewDTO.getActivityId()).orElseThrow());
        review.setHotel(this.hotelRepository.findById(reviewDTO.getHotelId()).orElseThrow());
        review.setRestaurant(this.restaurantRepository.findById(reviewDTO.getRestaurantId()).orElseThrow());
        review.setUser(this.userRepository.findById(reviewDTO.getUsername()).orElseThrow());
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        return this.reviewRepository.save(review);
    }

    public List<Review> getReviewsByPlace(Long placeId){
        Place place = this.placeRepository.findByPlaceIdAndIsActive(placeId, true);
        return this.reviewRepository.findByPlaceAndIsActive(place, true);
    }

    public List<Review> getReviewsByActivity(Long activityId){
        Activity activity = this.activityRepository.findByActivityIdAndIsActive(activityId, true);
        return this.reviewRepository.findByActivityAndIsActive(activity, true);
    }

    public List<Review> getReviewsByHotel(Long hotelId){
        Hotel hotel = this.hotelRepository.findByHotelIdAndIsActive(hotelId, true);
        return this.reviewRepository.findByHotelAndIsActive(hotel, true);
    }

    public List<Review> getReviewsByRestaurant(Long restaurantId){
        Restaurant restaurant = this.restaurantRepository.findByRestaurantIdAndIsActive(restaurantId, true);
        return this.reviewRepository.findByRestaurantAndIsActive(restaurant, true);
    }

    public List<Review> getReviewsByUser(String username){
        User user = this.userRepository.findById(username).orElseThrow();
        return this.reviewRepository.findByUserAndIsActive(user, true);
    }

    public Review deleteReview(Long reviewId){
        Review review = this.reviewRepository.findById(reviewId).orElseThrow();
        review.setIsActive(false);
        return this.reviewRepository.save(review);
    }
}