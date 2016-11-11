package com.ticket.services;

import com.ticket.exceptions.AlreadyBoughtTicketException;
import com.ticket.exceptions.NotEnoughMoneyOnBalanceException;
import com.ticket.models.Event;
import com.ticket.models.Ticket;
import com.ticket.models.User;

import java.util.List;

/**
 * Service for {@link com.ticket.models.Ticket}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface TicketService {

     List<Ticket> getAllTicketsToEvent(Event event);

     void save(Ticket ticket);

     List<Ticket> getTicketsBySeller(User user);

    void buyTicket(int ticketId, int buyerId) throws AlreadyBoughtTicketException, NotEnoughMoneyOnBalanceException;

    Ticket getTicketById(int ticketId);

    List<Ticket> getAvailableTicketsToEvent(Event event);

    void removeBuyerFromTicket(Ticket ticket);

    boolean isTicketAvailableToBuy(Ticket ticket, User buyer) throws NotEnoughMoneyOnBalanceException, AlreadyBoughtTicketException;

    void delete(Ticket ticket);

    void deleteTicketsToEvent(Event event);

}
