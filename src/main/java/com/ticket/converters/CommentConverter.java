package com.ticket.converters;

import com.ticket.DTO.CommentDTO;
import com.ticket.models.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Admin on 10.10.2016.
 */
@Component
public class CommentConverter {

    public Comment convertCommentDTOToCommentEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setUsername(commentDTO.getUsername());
        comment.setEvent(commentDTO.getEvent());
        comment.setText(commentDTO.getText());
        comment.setCommentDate(commentDTO.getCommentDate());
        return comment;
    }


    public CommentDTO convertCommentEntityToCommentDTO(Comment commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setText(commentEntity.getText());
        commentDTO.setId(commentEntity.getId());
        commentDTO.setEvent(commentEntity.getEvent());
        commentDTO.setUsername(commentEntity.getUsername());
        commentDTO.setCommentDate(commentEntity.getCommentDate());
        return commentDTO;
    }

    public List<CommentDTO> convertEntityListToDTOList(List<Comment> entityList){
        List<CommentDTO> dtoList = entityList.stream().map(this::convertCommentEntityToCommentDTO)
                .collect(Collectors.toList());
        return dtoList;
    }

    public List<Comment> convertDTOListToEntityList(List<CommentDTO> dtoList){
        List<Comment> entityList = dtoList.stream().map(this::convertCommentDTOToCommentEntity)
                .collect(Collectors.toList());
        return entityList;
    }

}
