package com.tourism.backend.controller;

import com.tourism.backend.dto.HotelDTO;
import com.tourism.backend.entity.Activity;
import com.tourism.backend.entity.Hotel;
import com.tourism.backend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel createdHotel = hotelService.createHotel(hotelDTO);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = hotelService.getHotelsByIsActive( );
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Hotel>> getHotelsByPlace(@PathVariable Long placeId) {
        List<Hotel> hotels = hotelService.getHotelsByPlace(placeId);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel updatedHotel = hotelService.updateHotel(hotelDTO);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable Long hotelId) {
        Hotel deletedHotel = hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(deletedHotel, HttpStatus.OK);
    }
}
