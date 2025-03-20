package com.repositories;

import com.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    // On déclare juste la méthode de recherche sur "pizzaId" et "isApproved = true"
    List<Comment> findByPizzaIdAndIsApprovedTrue(Integer pizzaId);
}
