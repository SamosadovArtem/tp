package com.ticket.converters;

import com.ticket.DTO.DealDTO;
import com.ticket.models.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  Converter for {@link com.ticket.models.Deal} entity
 *
 *  @author Artem Samosadov
 *  @version 1.0
 */
@Component
public class DealConverter {

    @Autowired
    UserConverter userConverter;

    @Autowired TicketConverter ticketConverter;

    public Deal convertDealDTOToDealEntity(DealDTO dealDTO) {
        Deal deal = new Deal();
        deal.setSeller(userConverter.convertUserDTOToUserEntity(dealDTO.getSeller()));
        deal.setId(dealDTO.getId());
        deal.setTicket(ticketConverter.convertTicketDTOToTicketEntity(dealDTO.getTicket()));
        deal.setBuyer(userConverter.convertUserDTOToUserEntity(dealDTO.getBuyer()));
        return deal;
    }


    public DealDTO convertDealEntityToDealDTO(Deal dealEntity) {
        DealDTO dealDTO = new DealDTO();
        dealDTO.setSeller(userConverter.convertUserEntityToUserDTO(dealEntity.getSeller()));
        dealDTO.setId(dealEntity.getId());
        dealDTO.setTicket(ticketConverter.convertTicketEntityToTicketDTO(dealEntity.getTicket()));
        dealDTO.setBuyer(userConverter.convertUserEntityToUserDTO(dealEntity.getBuyer()));
        return dealDTO;
    }

    public List<DealDTO> convertEntityListToDTOList(List<Deal> entityList) {
        List<DealDTO> dtoList = entityList.stream().map(this::convertDealEntityToDealDTO)
                .collect(Collectors.toList());
        return dtoList;
    }


    public List<Deal> convertDTOListToEntityList(List<DealDTO> dtoList) {
        List<Deal> entityList = dtoList.stream().map(this::convertDealDTOToDealEntity)
                .collect(Collectors.toList());
        return entityList;
    }

}
