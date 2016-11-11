package com.ticket.services;

import com.ticket.models.Deal;
import com.ticket.models.User;

import java.util.List;

/**
 * Service for {@link com.ticket.models.Deal}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface DealService {

    List<Deal> getDealsByBuyer(User user);

    Deal getDealById(int dealId);

    void approveDeal(Deal deal);

    void cancelDeal(Deal deal);

    void saveDeal(Deal deal);

    void deleteDeal(Deal deal);

    List<Deal> getDealsBySeller(User seller);
}
