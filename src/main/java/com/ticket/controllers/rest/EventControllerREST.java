package com.ticket.controllers.rest;

import com.ticket.DTO.EventDTO;
import com.ticket.converters.EventConverter;
import com.ticket.models.Event;
import com.ticket.models.EventType;
import com.ticket.services.EventService;
import com.ticket.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * Created by Admin on 03.08.2016.
 */
@RestController
@RequestMapping("/api/v1/events")
public class EventControllerREST {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventTypeService eventTypeService;

    @Autowired
    private EventConverter eventConverter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventDTO>> getEvents(@RequestParam(value = "typeId", required = false) String typeId) {
        if (typeId == null) {

            List<EventDTO> allDTOEvents = eventConverter.convertEntityListToDTOList(eventService.getAllEvents());

            return ResponseEntity.ok(allDTOEvents);

        } else {

            EventType eventType = eventTypeService.getEventTypeById(Integer.valueOf(typeId));

            List<EventDTO> dtoEventsWithSelectedType = eventConverter.convertEntityListToDTOList
                    (eventService.getEventsByEventType(eventType));

            return ResponseEntity.ok(dtoEventsWithSelectedType);
        }
    }

    @RequestMapping(value ="/{eventId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDTO> getEventById(@PathVariable("eventId") Integer eventId) {

        EventDTO eventDTO = eventConverter.convertEventEntityToEventDTO(eventService.getEventById(eventId));

        return ResponseEntity.ok(eventDTO);
    }

    @RequestMapping(value ="/{eventId}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEventById(@RequestBody EventDTO eventDTO) {

        Event event = eventConverter.convertEventDTOToEventEntity(eventDTO);

        eventService.updateEvent(event);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value ="/{eventId}",method = RequestMethod.DELETE)
    public ResponseEntity<Event> deleteEventById(@PathVariable("eventId") Integer eventId) {

        eventService.deleteById(eventId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO eventDTO) {

        Event event = eventConverter.convertEventDTOToEventEntity(eventDTO);

        eventService.createEvent(event);

        return new ResponseEntity(event,HttpStatus.CREATED);
    }
}
