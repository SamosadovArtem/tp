package com.ticket.repository.impl;

import com.ticket.models.EventType;
import com.ticket.repository.EventTypeRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link EventTypeRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class EventTypeRepositoryImpl  extends CRUDRepositoryImpl<EventType> implements EventTypeRepository {

    public EventTypeRepositoryImpl() {
        super(EventType.class);
    }
}
