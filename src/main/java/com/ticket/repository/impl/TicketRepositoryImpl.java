package com.ticket.repository.impl;

import com.ticket.models.Event;
import com.ticket.models.Ticket;
import com.ticket.models.User;
import com.ticket.repository.TicketRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link TicketRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class TicketRepositoryImpl extends CRUDRepositoryImpl<Ticket> implements TicketRepository {

    @PersistenceContext
    private EntityManager em;

    public TicketRepositoryImpl() {
        super(Ticket.class);
    }

    @Override
    public List<Ticket> findAllTicketsToEvent(Event event) {

        return em.createQuery("select t from Ticket t where t.event = :currentEvent")
                .setParameter("currentEvent", event)
                .getResultList();
    }

    @Override
    public List<Ticket> findAllTicketsBySeller(User user) {
        return em.createQuery("select t from Ticket t where t.seller = :currentUser")
                .setParameter("currentUser",user.getId())
                .getResultList();
    }

    @Override
    public void deleteTicketsToEvent(Event event) {
        em.createQuery("delete from Ticket t where t.event = :currentEvent")
                .setParameter("currentEvent", event)
                .executeUpdate();
    }
}
