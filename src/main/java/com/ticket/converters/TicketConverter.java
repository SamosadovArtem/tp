package com.ticket.converters;

import com.ticket.DTO.TicketDTO;
import com.ticket.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter for {@link com.ticket.models.Ticket} entity
 *
 * @author Artem Samosadov
 * @version 1.0
 */

@Component
public class TicketConverter {

    @Autowired
    EventConverter eventConverter;

    public Ticket convertTicketDTOToTicketEntity(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());

        if (ticketDTO.getBuyer() != null) {
            ticket.setBuyer(ticketDTO.getBuyer());
        }

        ticket.setSeller(ticketDTO.getBuyer());
        ticket.setCost(ticketDTO.getCost());
        ticket.setEvent(eventConverter.convertEventDTOToEventEntity(ticketDTO.getEvent()));
        ticket.setDetails(ticketDTO.getDetails());

        return ticket;
    }


    public TicketDTO convertTicketEntityToTicketDTO(Ticket ticketEntity) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticketEntity.getId());
        ticketDTO.setBuyer(ticketEntity.getBuyer());

        if (ticketEntity.getBuyer() != null) {
            ticketDTO.setSeller(ticketEntity.getBuyer());
        }

        ticketDTO.setCost(ticketEntity.getCost());
        ticketDTO.setEvent(eventConverter.convertEventEntityToEventDTO(ticketEntity.getEvent()));
        ticketDTO.setDetails(ticketEntity.getDetails());

        return ticketDTO;
    }


    public List<TicketDTO> convertEntityListToDTOList(List<Ticket> entityList) {
        List<TicketDTO> dtoList = entityList.stream().map(this::convertTicketEntityToTicketDTO)
                .collect(Collectors.toList());
        return dtoList;
    }


    public List<Ticket> convertDTOListToEntityList(List<TicketDTO> dtoList) {
        List<Ticket> entityList = dtoList.stream().map(this::convertTicketDTOToTicketEntity)
                .collect(Collectors.toList());
        return entityList;
    }

}
