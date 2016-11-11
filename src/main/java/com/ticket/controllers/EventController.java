package com.ticket.controllers;

import com.ticket.DTO.CommentDTO;
import com.ticket.DTO.EventDTO;
import com.ticket.converters.CommentConverter;
import com.ticket.converters.EventConverter;
import com.ticket.models.Event;
import com.ticket.models.EventType;
import com.ticket.services.CommentService;
import com.ticket.services.EventService;
import com.ticket.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Admin on 08.09.2016.
 */

@Controller
public class EventController extends BaseController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventConverter eventConverter;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentConverter commentConverter;

    @Autowired
    private EventTypeService eventTypeService;

    @RequestMapping(value = "/eventinfo",method = RequestMethod.GET)
    public String getEventById(@RequestParam(value = "eventId") String eventId, Model model,
                               @AuthenticationPrincipal org.springframework.security.core.userdetails.User activeUser){

        Event currentEvent = eventService.getEventById(Integer.valueOf(eventId));

        EventDTO eventDTO = eventConverter.convertEventEntityToEventDTO(currentEvent);

        List<CommentDTO> commentDTOList = commentConverter.convertEntityListToDTOList
                (commentService.getAllCommentsToEvent(currentEvent));

        model.addAttribute("event", eventDTO);
        model.addAttribute("comments", commentDTOList);

        if(activeUser != null){
            model.addAttribute("username", activeUser.getUsername());
        }

        return "views/event_info";
    }

    @RequestMapping(value = "/eventsbytype",method = RequestMethod.GET)
    public String getEventsWithSelectedType(@RequestParam(value = "typeId") String typeId, Model model){

        EventType eventType = eventTypeService.getEventTypeById(Integer.valueOf(typeId));

        List<EventDTO> dtoEventsWithSelectedType = eventConverter.convertEntityListToDTOList
                (eventService.getEventsByEventType(eventType));

        model.addAttribute("selectedEvents", dtoEventsWithSelectedType);

        return "views/eventswithselectedtype";
    }

    @RequestMapping(value = "/search", method=RequestMethod.GET)
    public String getSearchResult(Model model, @RequestParam(value = "eventTitle") String eventTitle ){

        List<EventDTO> dtoEventsWithSelectedTitle = eventConverter.convertEntityListToDTOList
                (eventService.getEventsByTitle(eventTitle));

        model.addAttribute("foundedEvents", dtoEventsWithSelectedTitle);

        return "views/event_search_page";
    }

}
