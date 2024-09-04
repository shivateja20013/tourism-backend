package com.tourism.backend.controller;

import com.tourism.backend.dto.ImageDTO;
import com.tourism.backend.entity.Image;
import com.tourism.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody ImageDTO imageDTO) {
        Image createdImage = this.imageService.createImage(imageDTO);
        return new ResponseEntity<>(createdImage, HttpStatus.CREATED);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Image>> getImagesByPlace(@PathVariable Long placeId) {
        List<Image> images = imageService.getImagesByPlace(placeId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Image>> getImagesByActivity(@PathVariable Long activityId) {
        List<Image> images = imageService.getImagesByActivity(activityId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Image>> getImagesByHotel(@PathVariable Long hotelId) {
        List<Image> images = imageService.getImagesByHotel(hotelId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Image>> getImagesByRestaurant(@PathVariable Long restaurantId) {
        List<Image> images = imageService.getImagesByRestaurant(restaurantId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<Image> deleteImage(@PathVariable Long imageId) {
        Image image = imageService.deleteImage(imageId);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
