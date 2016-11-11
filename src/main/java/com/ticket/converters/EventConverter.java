package com.ticket.converters;

import com.ticket.DTO.EventDTO;
import com.ticket.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter for {@link Event} entity
 *
 * @author Artem Samosadov
 * @version 1.0
 */

@Component
public final class EventConverter {

    @Autowired
    EventTypeConverter eventTypeConverter;

    public Event convertEventDTOToEventEntity(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setEventType(eventTypeConverter.convertEventTypeDTOToEventTypeEntity(eventDTO.getEventType()));
        event.setConfirmed(eventDTO.isConfirmed());
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setPlace(eventDTO.getPlace());
        return event;
    }


    public EventDTO convertEventEntityToEventDTO(Event eventEntity) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setPlace(eventEntity.getPlace());
        eventDTO.setId(eventEntity.getId());
        eventDTO.setDescription(eventEntity.getDescription());
        eventDTO.setTitle(eventEntity.getTitle());
        eventDTO.setConfirmed(eventEntity.getConfirmed());
        eventDTO.setEventType(eventTypeConverter.convertEventTypeEntityToEventTypeDTO(eventEntity.getEventType()));
        return eventDTO;
    }


    public List<EventDTO> convertEntityListToDTOList(List<Event> entityList) {
        List<EventDTO> dtoList = entityList.stream().map(this::convertEventEntityToEventDTO)
                .collect(Collectors.toList());
        return dtoList;
    }


    public List<Event> convertDTOListToEntityList(List<EventDTO> dtoList) {
        if (dtoList != null) {
            List<Event> entityList = dtoList.stream().map(this::convertEventDTOToEventEntity)
                    .collect(Collectors.toList());
            return entityList;
        } else {
            return new ArrayList<>();
        }
    }
}
