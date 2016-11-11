package com.ticket.controllers.rest;

import com.ticket.DTO.PlaceDTO;
import com.ticket.converters.PlaceConverter;
import com.ticket.services.PlaceService;
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
@RequestMapping("/api/v1/places")
public class PlaceControllerREST {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceConverter placeConverter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlaceDTO>> getEvents() {

        List<PlaceDTO> allDTOPlaces = placeConverter.convertEntityListToDTOList(placeService.getAllPlaces());

        return ResponseEntity.ok(allDTOPlaces);
    }

}
