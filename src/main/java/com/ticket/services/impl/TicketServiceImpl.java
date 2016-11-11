package com.ticket.services.impl;

import com.ticket.exceptions.AlreadyBoughtTicketException;
import com.ticket.exceptions.NotEnoughMoneyOnBalanceException;
import com.ticket.locale.MessageService;
import com.ticket.models.Event;
import com.ticket.models.Ticket;
import com.ticket.models.User;
import com.ticket.repository.TicketRepository;
import com.ticket.services.TicketService;
import com.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link TicketService}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Override
    @Transactional
    public List<Ticket> getAllTicketsToEvent(Event event) {
        return ticketRepository.findAllTicketsToEvent(event);
    }

    @Override
    @Transactional
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsBySeller(User user) {
        return ticketRepository.findAllTicketsBySeller(user);
    }

    @Override
    @Transactional
    synchronized public void buyTicket(int ticketId, int buyerId) throws AlreadyBoughtTicketException, NotEnoughMoneyOnBalanceException {

        Ticket ticket = this.getTicketById(ticketId);

        User buyer = userService.getById(buyerId);

        if (isTicketAvailableToBuy(ticket, buyer)) {
            userService.removeMoney(buyer, ticket.getCost());
            ticket.setBuyer(buyerId);
            ticketRepository.update(ticket);
        }
    }

    @Override
    @Transactional
    public Ticket getTicketById(int ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    @Transactional
    public List<Ticket> getAvailableTicketsToEvent(Event event) {

        List<Ticket> allTicketsToEvent = getAllTicketsToEvent(event);

        List<Ticket> availableTickets = allTicketsToEvent.stream()
                .filter(ticket -> ticket.isAvailable()).collect(Collectors.toList());

        return availableTickets;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeBuyerFromTicket(Ticket ticket) {
        ticket.setBuyer(null);
        ticketRepository.update(ticket);
    }

    @Override
    public boolean isTicketAvailableToBuy(Ticket ticket, User buyer) throws NotEnoughMoneyOnBalanceException, AlreadyBoughtTicketException {
        if (ticket.getBuyer() != null) {
            throw new AlreadyBoughtTicketException(messageService.getMessage("ticket.exception.buy"));
        } else {
            if (ticket.getCost().compareTo(buyer.getBalance()) == 1) {
                throw new NotEnoughMoneyOnBalanceException(messageService.getMessage("ticket.exception.notEnoughMoney"), buyer);
            } else {
                return true;
            }
        }
    }

    @Override
    @Transactional
    public void delete(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTicketsToEvent(Event event) {
        ticketRepository.deleteTicketsToEvent(event);
    }
}
