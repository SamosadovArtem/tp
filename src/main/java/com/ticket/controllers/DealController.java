package com.ticket.controllers;

import com.ticket.converters.DealConverter;
import com.ticket.models.Deal;
import com.ticket.services.DealService;
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

import java.util.List;

/**
 * Controller for {@link com.ticket.models.Deal} entity
 * extend {@link BaseController}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Controller
public class DealController extends BaseController {

    private final String CURRENT_DEAL_ATTRIBUTE_NAME = "deal";
    private final String ALL_DEALS_ATTRIBUTE_NAME = "deals";

    @Autowired
    private DealService dealService;

    @Autowired
    private UserService userService;

    @Autowired
    private DealConverter dealConverter;

    @RequestMapping(value = "/user_deals_buy",method = RequestMethod.GET)
    @Secured("ROLE_USER")
    public String getBuyerDeals(@AuthenticationPrincipal User activeUser, Model model,
                                @RequestParam(value = "dealId", required = false) String dealId){

        com.ticket.models.User currentUser = userService.findByUsername(activeUser.getUsername());

        if (dealId != null){

            Deal deal = dealService.getDealById(Integer.valueOf(dealId));

            if(deal != null && deal.getBuyer().getId() == currentUser.getId()) {

                model.addAttribute(CURRENT_DEAL_ATTRIBUTE_NAME, dealConverter.convertDealEntityToDealDTO(deal));

            } else {

                model.addAttribute("errorMessage", "You can't watch this deal");
            }

            return "views/current_user_deal_buy";

        } else {

            List<Deal> userDeals = dealService.getDealsByBuyer(currentUser);

            model.addAttribute(ALL_DEALS_ATTRIBUTE_NAME, dealConverter.convertEntityListToDTOList(userDeals));

            return "views/user_deals_buy";
        }
    }

    @RequestMapping(value = "/user_deals_sell", method = RequestMethod.GET)
    @Secured("ROLE_USER")
    public String getUserDealsToSell(@AuthenticationPrincipal User activeUser, Model model,
                                     @RequestParam(value = "dealId", required = false) String dealId){

        com.ticket.models.User currentUser = userService.findByUsername(activeUser.getUsername());

        if (dealId != null){

            Deal deal = dealService.getDealById(Integer.valueOf(dealId));

            if(deal != null && deal.getSeller().getId() == currentUser.getId()){

                model.addAttribute(CURRENT_DEAL_ATTRIBUTE_NAME, dealConverter.convertDealEntityToDealDTO(deal));

            } else {

                model.addAttribute("errorMessage", "You can't watch this deal");
            }

            return "views/current_user_deal_sell";

        } else {

            List<Deal> userDeals = dealService.getDealsBySeller(currentUser);

            model.addAttribute(ALL_DEALS_ATTRIBUTE_NAME, dealConverter.convertEntityListToDTOList(userDeals));

            return "views/user_deals_sell";

        }
    }

    @RequestMapping(value = "/approve_deal", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String approveDeal(@ModelAttribute (value = "dealId") String dealId){

        Deal deal = dealService.getDealById(Integer.valueOf(dealId));

        dealService.approveDeal(deal);

        return "redirect:/user_deals_buy";

    }

    @RequestMapping(value = "/cancel_deal", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String cancelDeal(@ModelAttribute (value = "dealId") String dealId){

        Deal deal = dealService.getDealById(Integer.valueOf(dealId));

        dealService.cancelDeal(deal);

        return "redirect:/user_deals_buy";
    }
}
