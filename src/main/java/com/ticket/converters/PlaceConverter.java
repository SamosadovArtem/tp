package com.ticket.converters;

import com.ticket.DTO.PlaceDTO;
import com.ticket.models.Place;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter for {@link Place} entity
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Component
public class PlaceConverter {

    public Place convertPlaceDTOToPlaceEntity(PlaceDTO placeDTO) {
        Place place = new Place();
        place.setId(placeDTO.getId());
        place.setCity(placeDTO.getCity());
        place.setTitle(placeDTO.getTitle());
        return place;
    }


    public PlaceDTO convertPlaceEntityToPlaceDTO(Place placeEntity) {
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(placeEntity.getId());
        placeDTO.setCity(placeEntity.getCity());
        placeDTO.setTitle(placeEntity.getTitle());
        return placeDTO;
    }


    public List<PlaceDTO> convertEntityListToDTOList(List<Place> entityList) {
        List<PlaceDTO> dtoList = entityList.stream().map(this::convertPlaceEntityToPlaceDTO)
                .collect(Collectors.toList());
        return dtoList;
    }


    public List<Place> convertDTOListToEntityList(List<PlaceDTO> dtoList) {
        List<Place> entityList = dtoList.stream().map(this::convertPlaceDTOToPlaceEntity)
                .collect(Collectors.toList());
        return entityList;
    }
}
