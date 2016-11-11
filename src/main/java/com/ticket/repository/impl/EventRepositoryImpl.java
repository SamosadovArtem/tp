package com.ticket.repository.impl;

import com.ticket.models.Event;
import com.ticket.models.EventType;
import com.ticket.repository.EventRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link EventRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class EventRepositoryImpl extends CRUDRepositoryImpl<Event> implements EventRepository {

    @PersistenceContext
    private EntityManager em;

    public EventRepositoryImpl() {
        super(Event.class);
    }

    @Override
    public List<Event> getEventsByEventType(EventType eventType){
        return em.createQuery("select e from Event e where e.eventType = :eventType")
                .setParameter("eventType", eventType)
                .getResultList();
    }

    @Override
    public List<Event> getEventsByTitle(String title){
        return em.createQuery("select e from Event e where e.title = :eventTitle")
                .setParameter("eventTitle", title)
                .getResultList();
    }
}
