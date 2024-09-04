package com.tourism.backend.controller;

import com.tourism.backend.dto.PlaceDTO;
import com.tourism.backend.entity.Place;
import com.tourism.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody PlaceDTO placeDTO) {
        Place createdPlace = this.placeService.createPlace(placeDTO);
        return new ResponseEntity<>(createdPlace, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        Place place = placeService.getPlaceById(id);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @GetMapping("/name/{placeName}")
    public ResponseEntity<Place> getPlaceByName(@PathVariable String placeName) {
        Place place = placeService.getPlaceByName(placeName);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Place>> getAllActivePlaces() {
        List<Place> activePlaces = placeService.getAllActivePlaces();
        return new ResponseEntity<>(activePlaces, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Place> updatePlace(@RequestBody PlaceDTO placeDTO) {
        Place updatedPlace = placeService.updatePlace(placeDTO);
        return updatedPlace != null ? ResponseEntity.ok(updatedPlace) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        boolean deleted = placeService.deletePlace(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
