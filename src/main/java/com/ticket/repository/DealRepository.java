package com.ticket.repository;

import com.ticket.models.Deal;
import com.ticket.models.User;

import java.util.List;

/**
 * Repository for {@link Deal} entity
 * extend {@link CRUDRepository}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface DealRepository extends CRUDRepository<Deal> {

    List getDealsByBuyer(User user);

    List<Deal> getDealsBySeller(User seller);
}
