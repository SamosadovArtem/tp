package com.ticket.controllers.rest;

import com.ticket.DTO.CommentDTO;
import com.ticket.converters.CommentConverter;
import com.ticket.models.Comment;
import com.ticket.services.CommentService;
import com.ticket.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 19.10.2016.
 */
@RestController
@RequestMapping("/api/v1/comments")
public class CommentResource {

    @Autowired
    CommentService commentService;

    @Autowired
    EventService eventService;

    @Autowired
    CommentConverter commentConverter;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDTO>> saveComment(@RequestBody CommentDTO commentDTO) {

        Comment comment = commentConverter.convertCommentDTOToCommentEntity(commentDTO);

        commentService.saveComment(comment);

        return new ResponseEntity(commentDTO, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDTO>> getCommentsByEvent(@RequestParam(value = "eventId") String eventId) {

        List<Comment> comments = commentService.getAllCommentsToEvent(eventService.getEventById(Integer.valueOf(eventId)));

        List<CommentDTO> commentDTOList = commentConverter.convertEntityListToDTOList(comments);

        return ResponseEntity.ok(commentDTOList);

    }

}
