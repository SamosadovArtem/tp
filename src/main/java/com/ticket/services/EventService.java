package com.ticket.services;

import com.ticket.models.Event;
import com.ticket.models.EventType;

import java.util.List;

/**
 * Created by Admin on 03.08.2016.
 */
public interface EventService {

    public List<Event> getAllEvents();

    public Event getEventById(int id);

    public void updateEvent(Event event);

    public void deleteEvent(Event event);

    public void createEvent(Event event);

    public void deleteById(int id);

    List<Event> getEventsByEventType(EventType eventType);

    List<Event> getEventsByTitle(String title);


}
