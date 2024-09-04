package com.tourism.backend.service;

import com.tourism.backend.dto.PlaceDTO;
import com.tourism.backend.entity.Place;
import com.tourism.backend.repository.PlaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public Place createPlace(PlaceDTO placeDTO) {
        Place place = new Place();
        place.setPlaceId(placeDTO.getPlaceId());
        place.setPlaceName(placeDTO.getPlaceName());
        place.setDescription(placeDTO.getDescription());
        place.setEntryFee(placeDTO.getEntryFee());
        place.setDistrict(placeDTO.getDistrict());
        place.setState(placeDTO.getState());
        place.setPincode(placeDTO.getPincode());
        place.setMapLink(placeDTO.getMapLink());
        return this.placeRepository.save(place);
    }

    public Place getPlaceById(Long id) {
        return this.placeRepository.findByPlaceIdAndIsActive(id, true);
    }

    public Place getPlaceByName(String placeName) {
        return this.placeRepository.findByPlaceNameAndIsActive(placeName, true);
    }

    public List<Place> getAllActivePlaces() {
        return this.placeRepository.findByIsActive(true);
    }

    public Place updatePlace(PlaceDTO placeDTO) {
        Place place = new Place();
        place.setPlaceId(placeDTO.getPlaceId());
        place.setPlaceName(placeDTO.getPlaceName());
        place.setDescription(placeDTO.getDescription());
        place.setEntryFee(placeDTO.getEntryFee());
        place.setDistrict(placeDTO.getDistrict());
        place.setState(placeDTO.getState());
        place.setPincode(placeDTO.getPincode());
        place.setMapLink(placeDTO.getMapLink());
        return this.placeRepository.save(place);
    }

    public boolean deletePlace(Long id) {
        Place place = this.placeRepository.findById(id).orElseThrow();
        place.setIsActive(false);
        placeRepository.save(place);
        return true;
    }
}
