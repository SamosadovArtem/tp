package com.ticket.controllers;

import com.ticket.models.EventType;
import com.ticket.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by Admin on 08.09.2016.
 */

@Controller
public class BaseController{

    @Autowired
    private EventTypeService eventTypeService;


    @ModelAttribute("allEventTypes")
    public List<EventType> fillHeaderModel(){
        return eventTypeService.getAllEventTypes();
    }

}
