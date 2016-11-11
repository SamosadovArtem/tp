package com.ticket.converters;

import com.ticket.DTO.EventTypeDTO;
import com.ticket.models.EventType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter for {@link EventType} entity
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Component
public class EventTypeConverter {

    public EventType convertEventTypeDTOToEventTypeEntity(EventTypeDTO eventTypeDTO) {
        EventType eventType = new EventType();
        eventType.setId(eventTypeDTO.getId());
        eventType.setType(eventTypeDTO.getType());
        return eventType;
    }


    public EventTypeDTO convertEventTypeEntityToEventTypeDTO(EventType eventTypeEntity) {
        EventTypeDTO eventTypeDTO = new EventTypeDTO();
        eventTypeDTO.setId(eventTypeEntity.getId());
        eventTypeDTO.setType(eventTypeEntity.getType());
        return eventTypeDTO;
    }


    public List<EventTypeDTO> convertEntityListToDTOList(List<EventType> entityList) {
        List<EventTypeDTO> dtoList = entityList.stream().map(this::convertEventTypeEntityToEventTypeDTO)
                .collect(Collectors.toList());
        return dtoList;
    }


    public List<EventType> convertDTOListToEntityList(List<EventTypeDTO> dtoList) {
        List<EventType> entityList = dtoList.stream().map(this::convertEventTypeDTOToEventTypeEntity)
                .collect(Collectors.toList());
        return entityList;
    }
}
