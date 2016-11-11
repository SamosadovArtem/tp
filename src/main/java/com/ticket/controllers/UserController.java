package com.ticket.controllers;

import com.ticket.DTO.UserDTO;
import com.ticket.converters.CityConverter;
import com.ticket.converters.TicketConverter;
import com.ticket.converters.UserConverter;
import com.ticket.models.Ticket;
import com.ticket.models.User;
import com.ticket.services.CityService;
import com.ticket.services.TicketService;
import com.ticket.services.UserService;
import com.ticket.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for {@link User}
 * extends {@link BaseController}
 *
 * @author Artem Samosadov
 * @version 1.0
 */

@Controller
public class UserController extends BaseController {

    private final String ALL_CITIES_ATTRIBUTE_NAME = "cities";

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CityConverter cityConverter;

    @Autowired
    private TicketConverter ticketConverter;

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(Model model) {

        model.addAttribute(ALL_CITIES_ATTRIBUTE_NAME,
                cityConverter.convertEntityListToDTOList(cityService.getAllCities()));

        model.addAttribute("newUser", new UserDTO());

        return "views/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute(value = "newUser") UserDTO newUser, BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(ALL_CITIES_ATTRIBUTE_NAME,
                    cityConverter.convertEntityListToDTOList(cityService.getAllCities()));
            return "views/register";
        }

        User userEntity = userConverter.convertUserDTOToUserEntity(newUser);

        userService.save(userEntity);

        return "redirect:/login";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/user_ticket", method = RequestMethod.GET)
    public String getUserTicketToSell(
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User activeUser,
            Model model) {

        User currentUser = userService.findByUsername(activeUser.getUsername());

        List<Ticket> allTicketsToSell = ticketService.getTicketsBySeller(currentUser);

        model.addAttribute("tickets", ticketConverter.convertEntityListToDTOList(allTicketsToSell));

        return "views/user_tickets";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/user_personal", method = RequestMethod.GET)
    public String getUserPersonalPage(
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User activeUser,
            Model model) {

        User currentUser = userService.findByUsername(activeUser.getUsername());

        model.addAttribute("user", userConverter.convertUserEntityToUserDTO(currentUser));

        return "views/user_page";
    }
}
