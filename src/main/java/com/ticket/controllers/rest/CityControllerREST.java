package com.ticket.controllers.rest;

import com.ticket.DTO.CityDTO;
import com.ticket.converters.CityConverter;
import com.ticket.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 05.08.2016.
 */
@RestController
@RequestMapping("/api/v1/cities")
public class CityControllerREST {

    @Autowired
    private CityService cityService;

    @Autowired
    private CityConverter cityConverter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDTO>> getEvents() {

        List<CityDTO> allDTOCities = cityConverter.convertEntityListToDTOList(cityService.getAllCities());

        return ResponseEntity.ok(allDTOCities);
    }
}
