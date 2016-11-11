package com.ticket.services;

import com.ticket.models.EventType;

import java.util.List;

/**
 * Created by Admin on 28.07.2016.
 */
public interface EventTypeService {

    public List<EventType> getAllEventTypes();

    public EventType getEventTypeById(int id);

}
