package com.ticket.repository;

import com.ticket.models.Event;
import com.ticket.models.EventType;

import java.util.List;

/**
 * Created by Admin on 27.07.2016.
 */
public interface EventRepository extends CRUDRepository<Event>  {

    List<Event> getEventsByEventType(EventType eventType);

    List<Event> getEventsByTitle(String title);

}
