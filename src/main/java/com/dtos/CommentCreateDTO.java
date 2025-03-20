package com.dtos;

import lombok.Data;

/**
 * DTO pour la création d'un nouveau commentaire.
 */
@Data
public class CommentCreateDTO {
    private Integer pizzaId;
    private String content;
    private String photoUrl;
    // Informations minimales sur l'utilisateur qui poste le commentaire
    private Long userId;
    private String username;
}
