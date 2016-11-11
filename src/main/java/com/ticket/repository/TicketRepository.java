package com.ticket.repository;

import com.ticket.models.Event;
import com.ticket.models.Ticket;
import com.ticket.models.User;

import java.util.List;

/**
 * Repository for {@link Ticket} entity
 * extend {@link CRUDRepository}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface TicketRepository extends CRUDRepository<Ticket> {

    List<Ticket> findAllTicketsToEvent(Event event);

    List<Ticket> findAllTicketsBySeller(User user);

    void deleteTicketsToEvent(Event event);

}
