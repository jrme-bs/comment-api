package com.services.impl;

import com.dtos.CommentCreateDTO;
import com.dtos.CommentDTO;
import com.dtos.CommentUpdateDTO;
import com.entities.Comment;
import com.mappers.CommentMapper;
import com.repositories.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (createDTO == null || createDTO.getPizzaId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Les informations du commentaire sont incomplètes");
        }

        Comment comment = commentMapper.toEntity(createDTO);
        Comment saved = commentRepository.save(comment);
        return commentMapper.toDTO(saved);
    }

    /**
     * Met à jour un commentaire existant.
     */
    public CommentDTO updateComment(String id, CommentUpdateDTO updateDTO) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Commentaire non trouvé avec l'ID: " + id));

        commentMapper.updateEntity(comment, updateDTO);
        Comment updated = commentRepository.save(comment);
        return commentMapper.toDTO(updated);
    }

    /**
     * Supprime un commentaire.
     */
    public void deleteComment(String id) {
        if (!commentRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Commentaire non trouvé avec l'ID: " + id);
        }
        commentRepository.deleteById(id);
    }

    /**
     * Approuve un commentaire.
     */
    public CommentDTO approveComment(String id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Commentaire non trouvé avec l'ID: " + id));

        comment.setApproved(true);
        Comment approved = commentRepository.save(comment);
        return commentMapper.toDTO(approved);
    }
}