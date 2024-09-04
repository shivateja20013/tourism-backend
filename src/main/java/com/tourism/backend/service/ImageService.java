package com.tourism.backend.service;

import com.tourism.backend.dto.ImageDTO;
import com.tourism.backend.entity.*;
import com.tourism.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Image createImage(ImageDTO imageDTO){
        Image image = new Image();
        image.setImageId(imageDTO.getImageId());
        image.setPlace(this.placeRepository.findById(imageDTO.getPlaceId()).orElseThrow());
        image.setActivity(this.activityRepository.findById(imageDTO.getActivityId()).orElseThrow());
        image.setHotel(this.hotelRepository.findById(imageDTO.getHotelId()).orElseThrow());
        image.setRestaurant(this.restaurantRepository.findById(imageDTO.getRestaurantId()).orElseThrow());
        image.setImage(Base64Utils.decodeFromString(imageDTO.getImage()));
        return this.imageRepository.save(image);
    }

    public List<Image> getImagesByPlace(Long placeId){
        Place place = this.placeRepository.findByPlaceIdAndIsActive(placeId, true);
        return this.imageRepository.findByPlaceAndIsActive(place, true);
    }

    public List<Image> getImagesByActivity(Long activityId){
        Activity activity = this.activityRepository.findByActivityIdAndIsActive(activityId, true);
        return this.imageRepository.findByActivityAndIsActive(activity, true);
    }

    public List<Image> getImagesByHotel(Long hotelId){
        Hotel hotel = this.hotelRepository.findByHotelIdAndIsActive(hotelId, true);
        return this.imageRepository.findByHotelAndIsActive(hotel, true);
    }

    public List<Image> getImagesByRestaurant(Long restaurantId){
        Restaurant restaurant = this.restaurantRepository.findByRestaurantIdAndIsActive(restaurantId, true);
        return this.imageRepository.findByRestaurantAndIsActive(restaurant, true);
    }

    public Image deleteImage(Long imageId){
        Image image = this.imageRepository.findById(imageId).orElseThrow();
        image.setIsActive(false);
        return this.imageRepository.save(image);
    }
}
