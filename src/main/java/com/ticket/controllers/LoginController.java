package com.ticket.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  Controller for login and logout operations
 *  extends {@link BaseController}
 *
 *  @author Artem Samosadov
 *  @version 1.0
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "views/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            SecurityContextHolder.clearContext();
        }

        return "redirect:/login?logout";
    }
}
