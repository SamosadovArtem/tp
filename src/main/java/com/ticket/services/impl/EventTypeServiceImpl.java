package com.ticket.services.impl;

import com.ticket.models.EventType;
import com.ticket.repository.EventTypeRepository;
import com.ticket.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 28.07.2016.
 */
@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    @Transactional
    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    @Override
    @Transactional
    public EventType getEventTypeById(int id) {
        return eventTypeRepository.findById(id);
    }
}
