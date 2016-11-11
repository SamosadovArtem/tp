package com.ticket.services;

import com.ticket.models.Comment;
import com.ticket.models.Event;

import java.util.List;

/**
 * Service for {@link com.ticket.models.Comment} class
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface CommentService {

    List<Comment> getAllCommentsToEvent(Event event);

    void saveComment(Comment comment);

}
