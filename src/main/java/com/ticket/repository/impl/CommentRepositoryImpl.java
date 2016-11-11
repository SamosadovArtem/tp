package com.ticket.repository.impl;

import com.ticket.models.Comment;
import com.ticket.models.Event;
import com.ticket.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link CommentRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class CommentRepositoryImpl extends CRUDRepositoryImpl<Comment> implements CommentRepository {

    @PersistenceContext
    private EntityManager em;

    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> getAllCommentsToEvent(Event event) {
        return em.createQuery("select c from Comment c where c.event = :eventId")
                .setParameter("eventId", event.getId())
                .getResultList();
    }
}
