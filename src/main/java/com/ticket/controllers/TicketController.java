package com.ticket.controllers;

import com.ticket.DTO.TicketDTO;
import com.ticket.converters.TicketConverter;
import com.ticket.exceptions.AlreadyBoughtTicketException;
import com.ticket.exceptions.NotEnoughMoneyOnBalanceException;
import com.ticket.models.Deal;
import com.ticket.models.Event;
import com.ticket.models.Ticket;
import com.ticket.services.DealService;
import com.ticket.services.EventService;
import com.ticket.services.TicketService;
import com.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controller for {@link com.ticket.models.Ticket} entity
 * extend {@link BaseController}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Controller
public class TicketController extends BaseController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketConverter ticketConverter;

    @Autowired
    private DealService dealService;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/sellticket", method = RequestMethod.POST)
    public String addTicketForSale(@ModelAttribute(value = "eventId") String eventId,
                                   @ModelAttribute(value = "price") String price,
                                   @ModelAttribute(value = "details") String details,
                                   @AuthenticationPrincipal User activeUser) {

        com.ticket.models.User currentUser = userService.findByUsername(activeUser.getUsername());

        Event currentEvent = eventService.getEventById(Integer.valueOf(eventId));

        Ticket newTicket = new Ticket();

        newTicket.setSeller(Integer.valueOf(currentUser.getId()));
        newTicket.setCost(new BigDecimal(price));
        newTicket.setEvent(currentEvent);
        newTicket.setDetails(details);

        ticketService.save(newTicket);

        return "redirect:/user_ticket";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/ticketsforevent", method = RequestMethod.GET)
    public String getTicketsForEvent(@RequestParam(value = "eventId") String eventId, Model model) {

        Event currentEvent = eventService.getEventById(Integer.valueOf(eventId));

        List<Ticket> availableTickets = ticketService.getAvailableTicketsToEvent(currentEvent);

        List<TicketDTO> availableTicketsDTO = ticketConverter.convertEntityListToDTOList(availableTickets);

        model.addAttribute("tickets", availableTicketsDTO);

        return "views/tickets_to_event";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "buyticket", method = RequestMethod.POST)
    public String buyTicket(@ModelAttribute(value = "ticketId") int ticketId,
                            @AuthenticationPrincipal User activeUser,
                            RedirectAttributes redirectAttributes,
                            @ModelAttribute(value = "eventId") String eventId) {

        com.ticket.models.User currentUser = userService.findByUsername(activeUser.getUsername());

        try {
            ticketService.buyTicket(ticketId, currentUser.getId());
        } catch (AlreadyBoughtTicketException | NotEnoughMoneyOnBalanceException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            redirectAttributes.addAttribute("eventId", eventId);
            return "redirect:/ticketsforevent";
        }

        Ticket currentTicket = ticketService.getTicketById(ticketId);

        com.ticket.models.User seller = userService.getById(currentTicket.getSeller());

        Deal deal = new Deal();
        deal.setBuyer(currentUser);
        deal.setSeller(seller);
        deal.setTicket(currentTicket);
        dealService.saveDeal(deal);

        return "redirect:/user_deals_buy";


    }
}
