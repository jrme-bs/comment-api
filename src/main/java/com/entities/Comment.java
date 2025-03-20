package com.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Représente un commentaire stocké dans MongoDB.
 */
@Document(collection = "comments") // nom de la collection Mongo
public class Comment {

    @Id
    private String id;                   // Identifiant Mongo
    private Integer pizzaId;             // ID de la pizza concernée
    private CommentUser user;            // Informations minimales sur l'utilisateur
    private String content;              // Contenu du commentaire
    private LocalDateTime createdAt;     // Date de création

    public Comment() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters et Setters ...

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getPizzaId() { return pizzaId; }
    public void setPizzaId(Integer pizzaId) { this.pizzaId = pizzaId; }

    public CommentUser getUser() { return user; }
    public void setUser(CommentUser user) { this.user = user; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}