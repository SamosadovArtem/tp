package com.ticket.controllers.rest;

import com.ticket.DTO.EventTypeDTO;
import com.ticket.converters.EventTypeConverter;
import com.ticket.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 28.07.2016.
 */
@RestController
@RequestMapping("/api/v1/eventtypes")
public class EventTypeControllerREST {

    @Autowired
    private EventTypeService eventTypeService;

    @Autowired
    private EventTypeConverter eventTypeConverter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventTypeDTO>> getEventTypes() {

        List<EventTypeDTO> allDTOEventType = eventTypeConverter.convertEntityListToDTOList
                (eventTypeService.getAllEventTypes());

        return ResponseEntity.ok(allDTOEventType);

    }
}
