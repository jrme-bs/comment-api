package com.entities;

/**
 * Représente les informations minimales d'un utilisateur associées à un commentaire.
 */
public class CommentUser {

    private Long id;
    private String username;

    public CommentUser() {
    }

    public CommentUser(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
