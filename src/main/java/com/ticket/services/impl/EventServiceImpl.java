package com.ticket.services.impl;

import com.ticket.models.Event;
import com.ticket.models.EventType;
import com.ticket.repository.EventRepository;
import com.ticket.services.EventService;
import com.ticket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link EventService}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketService ticketService;

    @Override
    @Transactional
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    @Transactional
    public Event getEventById(int id){
        return eventRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateEvent(Event event) {
        eventRepository.update(event);
    }

    @Override
    @Transactional
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }

    @Override
    @Transactional
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Event currentEvent = eventRepository.findById(id);

        ticketService.deleteTicketsToEvent(currentEvent);

        eventRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Event> getEventsByEventType(EventType eventType) {
        return eventRepository.getEventsByEventType(eventType);
    }

    @Override
    @Transactional
    public List<Event> getEventsByTitle(String title) {
        return eventRepository.getEventsByTitle(title);
    }
}
