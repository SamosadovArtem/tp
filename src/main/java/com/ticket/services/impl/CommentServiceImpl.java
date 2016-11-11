package com.ticket.services.impl;

import com.ticket.models.Comment;
import com.ticket.models.Event;
import com.ticket.repository.CommentRepository;
import com.ticket.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link CommentService}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public List<Comment> getAllCommentsToEvent(Event event) {
        return commentRepository.getAllCommentsToEvent(event);
    }

    @Override
    @Transactional
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
