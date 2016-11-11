package com.ticket.repository.impl;

import com.ticket.models.Deal;
import com.ticket.models.User;
import com.ticket.repository.DealRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link DealRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class DealRepositoryImpl extends CRUDRepositoryImpl<Deal> implements DealRepository {

    @PersistenceContext
    private EntityManager em;

    public DealRepositoryImpl() {
        super(Deal.class);
    }

    @Override
    public List<Deal> getDealsByBuyer(User user) {
        return  em.createQuery("select d from Deal d where buyer = :buyer")
                .setParameter("buyer", user)
                .getResultList();
    }

    @Override
    public List<Deal> getDealsBySeller(User seller) {
        return  em.createQuery("select d from Deal d where seller = :seller")
                .setParameter("seller", seller)
                .getResultList();
    }

}
