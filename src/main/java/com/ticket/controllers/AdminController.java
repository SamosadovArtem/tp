package com.ticket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 08.09.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAdminPage(){
        return "views/admin_page";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/events")
    public String getAdminEventPage(){
        return "views/admin_events";
    }

}
