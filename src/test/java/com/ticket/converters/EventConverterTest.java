package com.ticket.converters;

import com.ticket.DTO.EventDTO;
import com.ticket.models.Event;
import com.ticket.models.EventType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 17.08.2016.
 */
public class EventConverterTest {

    @Autowired
    EventTypeConverter eventTypeConverter;

    @Test
    public void convertEventDTOToEventEntity() throws Exception {

        EventType eventType = new EventType();
        eventType.setId(1);
        eventType.setType("TestEventType");

        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(4);
        eventDTO.setConfirmed(true);
        eventDTO.setTitle("TestObj");
        eventDTO.setPlace(7);
        eventDTO.setDescription("Jst4Test");
        eventDTO.setEventType(eventTypeConverter.convertEventTypeEntityToEventTypeDTO(eventType));

        EventConverter eventConverter = new EventConverter();
        Event resultEvent = eventConverter.convertEventDTOToEventEntity(eventDTO);

        assertEventEquals(resultEvent, eventDTO);

    }

    @Test
    public void convertEventEntityToEventDTO() throws Exception {
        EventType eventType = new EventType();
        eventType.setId(1);
        eventType.setType("TestEventType");

        Event event = new Event();
        event.setId(4);
        event.setConfirmed(true);
        event.setTitle("TestObj");
        event.setPlace(7);
        event.setDescription("Jst4Test");
        event.setEventType(eventType);

        EventConverter eventConverter = new EventConverter();
        EventDTO eventDTO = new EventDTO();

        assertEventEquals(event,eventDTO);
    }

    @Test
    public void convertEntityListToDTOList() throws Exception {

        EventConverter eventConverter = new EventConverter();

        EventType eventType = new EventType();
        eventType.setId(1);
        eventType.setType("TestEventType");

        Event firstEvent = new Event();
        firstEvent.setId(4);
        firstEvent.setConfirmed(true);
        firstEvent.setTitle("TestObj");
        firstEvent.setPlace(7);
        firstEvent.setDescription("Jst4Test");
        firstEvent.setEventType(eventType);

        Event secondEvent = new Event();
        secondEvent.setId(2);
        secondEvent.setConfirmed(false);
        secondEvent.setTitle("NewTestObj");
        secondEvent.setPlace(11);
        secondEvent.setDescription("Same");
        secondEvent.setEventType(eventType);

        List<Event> eventList = new ArrayList<>();
        eventList.add(firstEvent);
        eventList.add(secondEvent);

        List<EventDTO> dtoList = eventConverter.convertEntityListToDTOList(eventList);

        for(int i = 0;i<eventList.size();i++){
            assertEventEquals(eventList.get(i),dtoList.get(i));
        }

    }

    @Test
    public void convertDTOListToEntityList() throws Exception {
        EventConverter eventConverter = new EventConverter();

        EventType eventType = new EventType();
        eventType.setId(1);
        eventType.setType("TestEventType");

        EventDTO firstEventDTO = new EventDTO();
        firstEventDTO.setId(4);
        firstEventDTO.setConfirmed(true);
        firstEventDTO.setTitle("TestObj");
        firstEventDTO.setPlace(7);
        firstEventDTO.setDescription("Jst4Test");
        firstEventDTO.setEventType(eventTypeConverter.convertEventTypeEntityToEventTypeDTO(eventType));

        EventDTO secondEventDTO = new EventDTO();
        secondEventDTO.setId(2);
        secondEventDTO.setConfirmed(false);
        secondEventDTO.setTitle("NewTestObj");
        secondEventDTO.setPlace(11);
        secondEventDTO.setDescription("Same");
        secondEventDTO.setEventType(eventTypeConverter.convertEventTypeEntityToEventTypeDTO(eventType));

        List<EventDTO> dtoList = new ArrayList<>();
        dtoList.add(firstEventDTO);
        dtoList.add(secondEventDTO);

        List<Event> eventList = eventConverter.convertDTOListToEntityList(dtoList);

        for (int i = 0; i < dtoList.size(); i++){
            assertEventEquals(eventList.get(i), dtoList.get(i));
        }

    }

    private void assertEventEquals(Event event, EventDTO eventDTO){
        Assert.assertEquals(event.getTitle(), eventDTO.getTitle());
        Assert.assertEquals(event.getConfirmed(), eventDTO.isConfirmed());
        Assert.assertEquals(event.getDescription(), eventDTO.getDescription());
        Assert.assertEquals(event.getEventType(), eventDTO.getEventType());
        Assert.assertEquals(event.getPlace(), eventDTO.getPlace());
        Assert.assertEquals(event.getId(), eventDTO.getId());
    }

}