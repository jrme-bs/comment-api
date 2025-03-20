package com.mappers;

import com.dtos.CommentCreateDTO;
import com.dtos.CommentDTO;
import com.dtos.CommentUpdateDTO;
import com.entities.Comment;
import com.entities.CommentUser;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    /**
     * Convertit une entité Comment en CommentDTO.
     */
    public CommentDTO toDTO(Comment comment) {
        if (comment == null) return null;
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setPizzaId(comment.getPizzaId());
        dto.setUser(comment.getUser());
        dto.setContent(comment.getContent());
        dto.setPhotoUrl(comment.getPhotoUrl());
        dto.setApproved(comment.isApproved());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }

    /**
     * Convertit un CommentCreateDTO en entité Comment.
     */
    public Comment toEntity(CommentCreateDTO createDTO) {
        if (createDTO == null) return null;
        Comment comment = new Comment();
        comment.setPizzaId(createDTO.getPizzaId());
        comment.setContent(createDTO.getContent());
        comment.setPhotoUrl(createDTO.getPhotoUrl());
        // Crée et affecte un CommentUser
        comment.setUser(new CommentUser(createDTO.getUserId(), createDTO.getUsername()));
        return comment;
    }

    /**
     * Met à jour une entité Comment avec les valeurs du CommentUpdateDTO.
     */
    public void updateEntity(Comment comment, CommentUpdateDTO updateDTO) {
        if (comment != null && updateDTO != null) {
            if (updateDTO.getContent() != null) {
                comment.setContent(updateDTO.getContent());
            }
            if (updateDTO.getPhotoUrl() != null) {
                comment.setPhotoUrl(updateDTO.getPhotoUrl());
            }
        }
    }
}
