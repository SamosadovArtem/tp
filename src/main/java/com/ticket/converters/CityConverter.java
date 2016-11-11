package com.ticket.converters;

import com.ticket.DTO.CityDTO;
import com.ticket.models.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  Converter for {@link City} entity
 *
 *  @author Artem Samosadov
 *  @version 1.0
 */
@Component
public class CityConverter {

    public City convertCityDTOToCityEntity(CityDTO cityDTO) {
        City city = new City();
        city.setTitle(cityDTO.getTitle());
        city.setId(cityDTO.getId());
        return city;
    }


    public CityDTO convertCityEntityToCityDTO(City cityEntity) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setTitle(cityEntity.getTitle());
        cityDTO.setId(cityEntity.getId());
        return cityDTO;
    }


    public List<CityDTO> convertEntityListToDTOList(List<City> entityList) {
        List<CityDTO> dtoList = entityList.stream().map(this::convertCityEntityToCityDTO)
                .collect(Collectors.toList());
        return dtoList;
    }


    public List<City> convertDTOListToEntityList(List<CityDTO> dtoList) {
        List<City> entityList = dtoList.stream().map(this::convertCityDTOToCityEntity)
                .collect(Collectors.toList());
        return entityList;
    }
}
