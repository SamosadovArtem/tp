package com.ticket.services.impl;

import com.ticket.models.Deal;
import com.ticket.models.User;
import com.ticket.repository.DealRepository;
import com.ticket.services.DealService;
import com.ticket.services.TicketService;
import com.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link DealService}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Override
    @Transactional
    public List<Deal> getDealsByBuyer(User user) {
        return dealRepository.getDealsByBuyer(user);
    }

    @Override
    @Transactional
    public Deal getDealById(int dealId) {
        return dealRepository.findById(dealId);
    }

    @Override
    @Transactional
    public void approveDeal(Deal deal) {

        User seller = deal.getSeller();

        userService.addMoney(seller, deal.getTicket().getCost());

        ticketService.delete(deal.getTicket());

        dealRepository.delete(deal);
    }

    @Override
    @Transactional
    public void cancelDeal(Deal deal) {

        User buyer = deal.getBuyer();

        userService.addMoney(buyer,deal.getTicket().getCost());

        dealRepository.delete(deal);

        ticketService.removeBuyerFromTicket(deal.getTicket());
    }

    @Override
    @Transactional
    public void saveDeal(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    @Transactional
    public void deleteDeal(Deal deal) {
        dealRepository.delete(deal);
    }

    @Override
    @Transactional
    public List<Deal> getDealsBySeller(User seller) {
        return dealRepository.getDealsBySeller(seller);
    }
}
