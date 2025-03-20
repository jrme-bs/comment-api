package com.repositories;

import com.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    // Méthode pour trouver tous les commentaires associés à une pizza
    List<Comment> findByPizzaId(Integer pizzaId);
}