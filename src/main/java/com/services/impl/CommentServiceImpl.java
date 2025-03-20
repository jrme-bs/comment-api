package com.services.impl;

import com.dtos.CommentCreateDTO;
import com.dtos.CommentDTO;
import com.dtos.CommentUpdateDTO;
import com.entities.Comment;
import com.mappers.CommentMapper;
import com.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    /**
     * Récupère tous les commentaires approuvés pour une pizza donnée.
     */
    public List<CommentDTO> getApprovedCommentsByPizzaId(Integer pizzaId) {
        return commentRepository.findByPizzaIdAndIsApprovedTrue(pizzaId)
                .stream()
                .map(commentMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Crée un nouveau commentaire.
     */
    public CommentDTO createComment(CommentCreateDTO createDTO) {
        Comment comment = commentMapper.toEntity(createDTO);
        Comment saved = commentRepository.save(comment);
        return commentMapper.toDTO(saved);
    }

    /**
     * Met à jour un commentaire existant.
     */
    public CommentDTO updateComment(String id, CommentUpdateDTO updateDTO) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        commentMapper.updateEntity(comment, updateDTO);
        Comment updated = commentRepository.save(comment);
        return commentMapper.toDTO(updated);
    }

    /**
     * Supprime un commentaire.
     */
    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

    /**
     * Approuve un commentaire.
     */
    public CommentDTO approveComment(String id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setApproved(true);
        Comment approved = commentRepository.save(comment);
        return commentMapper.toDTO(approved);
    }
}
