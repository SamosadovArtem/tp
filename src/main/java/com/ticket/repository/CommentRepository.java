package com.ticket.repository;

import com.ticket.models.Comment;
import com.ticket.models.Event;

import java.util.List;

/**
 * Created by Admin on 27.07.2016.
 */
public interface CommentRepository extends CRUDRepository<Comment>  {

    List<Comment> getAllCommentsToEvent(Event event);

}
