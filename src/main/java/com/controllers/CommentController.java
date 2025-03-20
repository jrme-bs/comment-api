package com.controllers;

import com.dtos.CommentCreateDTO;
import com.dtos.CommentDTO;
import com.dtos.CommentUpdateDTO;
import com.services.impl.CommentServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    /**
     * GET /api/comments/pizza/{id}
     * Récupère tous les commentaires pour une pizza spécifique.
     */
    @GetMapping("/pizza/{id}")
    public List<CommentDTO> getCommentsByPizza(@PathVariable("id") Integer pizzaId) {
        return commentService.getCommentsByPizzaId(pizzaId);
    }

    /**
     * POST /api/comments
     * Ajoute un nouveau commentaire sur une pizza.
     */
    @PostMapping
    public CommentDTO createComment(@RequestBody CommentCreateDTO createDTO) {
        return commentService.createComment(createDTO);
    }

    /**
     * PUT /api/comments/{id}
     * Met à jour un commentaire existant.
     */
    @PutMapping("/{id}")
    public CommentDTO updateComment(@PathVariable("id") String id, @RequestBody CommentUpdateDTO updateDTO) {
        return commentService.updateComment(id, updateDTO);
    }

    /**
     * DELETE /api/comments/{id}
     * Supprime un commentaire.
     */
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") String id) {
        commentService.deleteComment(id);
    }
}