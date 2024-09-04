package com.tourism.backend.service;

import com.tourism.backend.dto.HotelDTO;
import com.tourism.backend.entity.Activity;
import com.tourism.backend.entity.Hotel;
import com.tourism.backend.repository.HotelRepository;
import com.tourism.backend.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public Hotel createHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelDTO.getHotelId());
        hotel.setPlace(placeRepository.findById(hotelDTO.getPlaceId()).orElseThrow());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setDescription(hotelDTO.getDescription());
        hotel.setMinPrice(hotelDTO.getMinPrice());
        hotel.setMaxPrice(hotelDTO.getMaxPrice());
        hotel.setRating(hotelDTO.getRating());
        return hotelRepository.save(hotel);
    }

    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findByHotelIdAndIsActive(hotelId, true);
    }

    public List<Hotel> getHotelsByIsActive(){
        return this.hotelRepository.findByIsActive(true);
    }

    public List<Hotel> getHotelsByPlace(Long placeId) {
        return hotelRepository.findByPlaceAndIsActive(placeRepository.findById(placeId).orElseThrow(), true);
    }

    public Hotel updateHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelDTO.getHotelId());
        hotel.setPlace(placeRepository.findById(hotelDTO.getPlaceId()).orElseThrow());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setDescription(hotelDTO.getDescription());
        hotel.setMinPrice(hotelDTO.getMinPrice());
        hotel.setMaxPrice(hotelDTO.getMaxPrice());
        hotel.setRating(hotelDTO.getRating());
        return hotelRepository.save(hotel);
    }

    public Hotel deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        hotel.setIsActive(false);
        return hotelRepository.save(hotel);
    }
}
